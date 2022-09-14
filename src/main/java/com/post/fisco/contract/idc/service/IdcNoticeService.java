package com.post.fisco.contract.idc.service;

import com.post.config.SystemConfig;
import com.post.fisco.contract.utils.BcosSdkClient;
import com.post.fisco.contract.utils.BcosUtils;
import com.post.fisco.contract.idc.sol.IDCNoticeController;

import com.post.dao.NuccIdcNoticeMapper;
import com.post.dao.NuccIdcOpNoticeMapper;
import com.post.entity.NuccIdcNotice;
import com.post.entity.NuccIdcOpNotice;
import com.post.epcc.dto.EpccTradeDataDto;
import com.post.epcc.trade.EpccIDCNotice;
import com.post.epcc.dto.EpccTradeOpCntDto;
import com.post.epcc.dto.component.EpccTradeOpDto;
import com.post.utils.DateUtils;
import com.post.utils.JsonUtils;
import com.post.utils.StringUtils;
import lombok.extern.slf4j.Slf4j;

import org.fisco.bcos.sdk.abi.ABICodec;
import org.fisco.bcos.sdk.abi.ABICodecException;
import org.fisco.bcos.sdk.eventsub.EventCallback;
import org.fisco.bcos.sdk.model.EventLog;
import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigInteger;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 机房变动通知-处理逻辑
 */
@Slf4j
@Service
public class IdcNoticeService {
    //智能合约部署地址
    public static String address;
    //智能合约 通知类sol文件调用类
    public static IDCNoticeController noticeApi = null;


    public static IDCNoticeController getNoticeApi() {
        if (noticeApi == null) {
            try {
                noticeApi = IDCNoticeController.load(getAddress(), BcosSdkClient.getClient(), BcosSdkClient.cryptoKeyPair);
            } catch (Exception e) {
                e.printStackTrace();
                log.error("加载机房变通通知-api异常",e);
            }

        }
        return noticeApi;
    }

    //获取合约地址，如果地址为空，则进行合约发布
    public static String getAddress() {

        //尝试通过配置文件获取地址
        if (address == null) {
//            address = SystemConfig.getInstance().contractIdcNoticeAddress;
            log.info("通过配置文件-获取机房变更-合约地址【" + address + "】");
        }


        if (address == null) {
            log.error("通过配置文件-获取机房变更-合约地址失败！！！");

            //此段代码只有在非生成环境测试是生效
//            if (!SystemConfig.getInstance().active.equals("prod")) {
                try {
                    //发布合约，并且保存地址
                    address = IDCNoticeController.deploy(BcosSdkClient.getClient(), BcosSdkClient.cryptoKeyPair).getContractAddress();
                    log.info("通过deploy-获取机房变更-合约地址【" + address + "】");
                } catch (Exception e) {
                    e.printStackTrace();
                }
//            }

        }
        return address;
    }

    @Autowired
    NuccIdcNoticeMapper nuccIdcNoticeMapper;

    @Autowired
    NuccIdcOpNoticeMapper nuccIdcOpNoticeMapper;

    /**
     * 交房变动通知仅供开发过程中测试使用
     *
     * @param msg
     */
    public static void send(String msg) {
        BigInteger plannedStartTime = new BigInteger(System.currentTimeMillis() + "");
        BigInteger plannedEndTime = new BigInteger(System.currentTimeMillis() + "");
        String seriesNo = StringUtils.fillRight(StringUtils.getPrimaryKey(), 32, "0");

        EpccIDCNotice tradeDto = new EpccIDCNotice();
        tradeDto.setMsgId(seriesNo);
        tradeDto.setDrctn("02");
        tradeDto.setMsgTp("uops.020.000.01");
        tradeDto.setReIssrId("95580");
        tradeDto.setReqSysId("Pay");

        EpccTradeDataDto data = new EpccTradeDataDto();
        data.setCntSumNo(1);
        data.setDrctn("02");
        data.setMsgTp("uops.020.000.01");

        List<EpccTradeOpCntDto> cntDtoList = new ArrayList<>();
        EpccTradeOpCntDto cntDto = new EpccTradeOpCntDto();
        cntDto.setAccType(new String[]{"00"});
        cntDto.setBizChan("01");
        cntDto.setBizTypeList(new String[]{"0000"});
        cntDto.setCtnNo("1");
        cntDto.setContacts("010-68148980");
        cntDto.setContent(msg);
        cntDto.setDesc("所有接入机房的成员结构");
        try {
            cntDto.setStartTime(DateUtils.getDateStr(new Date(), "YYYYMMddHHmmss"));
            cntDto.setEndTime(DateUtils.getDateStr(new Date(), "YYYYMMddHHmmss"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cntDto.setIdcList("BJ10");
        cntDto.setOverOpera("联系我方");
        cntDto.setInfoNo(StringUtils.getPrimaryKey());
        cntDto.setInfoType("01");
        cntDto.setInstId("G4000311000018");
        cntDto.setInstName("网联清算有限公司");
        cntDto.setStatus(1);

        List<EpccTradeOpDto> opList = new ArrayList<>();
        EpccTradeOpDto op = new EpccTradeOpDto();
        op.setPayOp("03");
        opList.add(op);
        cntDto.setOpList(opList);
        cntDtoList.add(cntDto);
        data.setCntList(cntDtoList);
        tradeDto.setData(data);

        String json = JsonUtils.toJson(tradeDto);
        log.info("发送通知：" + json);
        getNoticeApi().createIDCNotice(seriesNo.getBytes(), plannedStartTime, plannedEndTime, BcosUtils.utf8StringToHex(json));
    }


    //接受机房变动通知
    public static String get(String seriesNo) {
        try {
            return getNoticeApi().geIDCNotice(seriesNo.getBytes());
        } catch (ContractException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 增加观察者
     */
    public void sub() {

        getNoticeApi().subscribeIDCNoticeSavedEvent(new EventCallback() {
            /**
             * 接受机房变更通知
             * @param i
             * @param logs
             */
            @Override
            public void onReceiveLog(int status, List<EventLog> logs) {
                IdcNoticeService.log.info("->接收到机房变通通知" + status);
                if (logs != null) {
                    for (EventLog log : logs) {
                        try {
                            List<Object> list = new ABICodec(BcosSdkClient.getClient().getCryptoSuite()).decodeEvent(IDCNoticeController.ABI,
                                    IDCNoticeController.IDCNOTICESAVED_EVENT.getName(), log);

                            for (Object str : list) {
                                String seriesNo_ = BcosUtils
                                        .hexToUtf8String(str.toString().replaceAll("0x", ""));

                                try {
                                    IdcNoticeService.log.info("-->收到机房变动通知-流水号:" + seriesNo_);
                                    String json = BcosUtils.hexToUtf8String(getNoticeApi().geIDCNotice(seriesNo_.getBytes()));
                                    IdcNoticeService.log.info("-->通过流水号获取消息内容:" + json);

                                    NuccIdcNotice notice = new NuccIdcNotice();
                                    notice.setContentJson(json);
                                    notice.setCreateDate(new Date());
                                    notice.setSeriesNo(seriesNo_);
                                    notice.setNoticeStatus("00");

                                    nuccIdcNoticeMapper.insert(notice);

                                    EpccIDCNotice<EpccTradeOpCntDto> dto = (EpccIDCNotice<EpccTradeOpCntDto>) JsonUtils.toObject(json, EpccIDCNotice.class);
                                    IdcNoticeService.log.info("-->机房变通通知条数:" + dto.getData().getCntList().size());
                                    List<EpccTradeOpCntDto> cntList = dto.getData().getCntList();

                                    for (int i = 0; i < cntList.size(); i++) {
                                        try {

                                            EpccTradeOpCntDto cntDto = JsonUtils.toObject(JsonUtils.toJson(cntList.get(i)), EpccTradeOpCntDto.class);
                                            NuccIdcOpNotice opNotice = new NuccIdcOpNotice();
                                            opNotice.setRecId(StringUtils.getPrimaryKey());
                                            opNotice.setCntNo(cntDto.getCtnNo());
                                            opNotice.setInfoNo(cntDto.getInfoNo());
                                            opNotice.setInfoType(cntDto.getInfoType());
                                            opNotice.setInstId(cntDto.getInstId());
                                            opNotice.setInstName(cntDto.getInstName());
                                            opNotice.setNoticeContent(cntDto.getContent());
                                            opNotice.setNoticeDesc(cntDto.getDesc());
                                            opNotice.setContacts(cntDto.getContacts());
                                            opNotice.setIdcList(cntDto.getIdcList());
                                            opNotice.setIdcList2(cntDto.getIdcList2());
                                            opNotice.setBizChan(cntDto.getCtnNo());
                                            opNotice.setBizTypeList(StringUtils.join(cntDto.getBizTypeList()));
                                            opNotice.setAccType(StringUtils.join(cntDto.getAccType()));

                                            if (cntDto.getOpList() != null) {
                                                opNotice.setOpList(JsonUtils.toJson(cntDto.getOpList()));
                                            }


                                            opNotice.setStartTime(cntDto.getStartTime());
                                            opNotice.setEndTime(cntDto.getEndTime());
                                            opNotice.setOverOpera(cntDto.getOverOpera());


                                            opNotice.setNoticeStatus(cntDto.getStatus() + "");
                                            opNotice.setSendStatus("00");
                                            nuccIdcOpNoticeMapper.insert(opNotice);
                                        } catch (Exception e) {
                                            IdcNoticeService.log.error("机房变动通知-入库异常", e);
                                            e.printStackTrace();
                                        }
                                    }
                                } catch (ContractException e) {
                                    IdcNoticeService.log.error("机房变动通知-解析异常", e);
                                    e.printStackTrace();
                                }
                            }

                        } catch (ABICodecException e) {
                            IdcNoticeService.log.error("机房变动通知-解析异常", e);
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
    }

    /**
     * 注册机房变动通知的观察者
     */
    @PostConstruct
    public void init() {
        sub();
    }
}
