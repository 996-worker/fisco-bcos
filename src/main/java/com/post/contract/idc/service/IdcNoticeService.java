package com.post.contract.idc.service;

import com.post.contract.utils.BcosSdkClient;
import com.post.contract.utils.BcosUtils;
import com.post.contract.idc.sol.IDCNoticeController;

import com.post.dao.NuccIdcNoticeMapper;
import com.post.dao.NuccIdcOpNoticeMapper;
import com.post.entity.NuccIdcNotice;
import com.post.entity.NuccIdcOpNotice;
import com.post.epcc.dto.EpccTradeDataDto;
import com.post.epcc.dto.EpccTradeDto;
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
 * 机房变更通知类底层服务
 */
@Slf4j
@Service
public class IdcNoticeService {
    //智能合约部署地址
    public static String address = null;
    //智能合约 通知类sol文件调用类
    public static IDCNoticeController noticeApi = null;


    public static IDCNoticeController getNoticeApi() {
        if (noticeApi == null) {
            try {
                noticeApi = IDCNoticeController.load(getAddress(), BcosSdkClient.getClient(), BcosSdkClient.cryptoKeyPair);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return noticeApi;
    }

    //获取合约地址，如果地址为空，则进行合约发布
    public static String getAddress() {
        if (address == null) {
            try {
                //发布合约，并且保存地址
                address = IDCNoticeController.deploy(BcosSdkClient.getClient(), BcosSdkClient.cryptoKeyPair).getContractAddress();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return address;
    }

    @Autowired
    NuccIdcNoticeMapper nuccIdcNoticeMapper;

    @Autowired
    NuccIdcOpNoticeMapper nuccIdcOpNoticeMapper;

    //发送机房变动通知
    public static void send(String msg) {
        BigInteger plannedStartTime = new BigInteger(System.currentTimeMillis() + "");
        BigInteger plannedEndTime = new BigInteger(System.currentTimeMillis() + "");
        String seriesNo = StringUtils.fillRight(StringUtils.getPrimaryKey(), 32, "0");

        EpccTradeDto tradeDto = new EpccTradeDto();
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
            cntDto.setEndTime(DateUtils.getDateStr(new Date(), "YYYYMMDDHHmmss"));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        cntDto.setIdcList("BJ10");
        cntDto.setInfoNo(seriesNo);
        cntDto.setInfoType("01");
        cntDto.setInstId("G4000311000018");
        cntDto.setInstName("网联清算有限公司");

        List<EpccTradeOpDto> opList = new ArrayList<>();
        EpccTradeOpDto op = new EpccTradeOpDto();
        op.setPayOp("03");
        opList.add(op);
        cntDto.setOpList(opList);
        cntDtoList.add(cntDto);
        data.setCntList(cntDtoList);
        tradeDto.setData(data);

        String json = JsonUtils.toJson(tradeDto);
        System.out.println(json);
        System.out.println(BcosUtils.utf8StringToHex(json));
        getNoticeApi().createIDCNotice(seriesNo.getBytes(), plannedStartTime, plannedEndTime, BcosUtils.utf8StringToHex(json));
    }

    public static void main(String[] args) {
        IdcNoticeService.send("BJ10机房重启");
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
                System.out.println("接收通知" + status);
                if (logs != null) {
                    for (EventLog log : logs) {
                        try {
                            List<Object> list = new ABICodec(BcosSdkClient.getClient().getCryptoSuite()).decodeEvent(IDCNoticeController.ABI,
                                    IDCNoticeController.IDCNOTICESAVED_EVENT.getName(), log);

                            for (Object str : list) {
                                String seriesNo_ = BcosUtils
                                        .hexToUtf8String(str.toString().replaceAll("0x", ""));

                                try {
                                    System.out.println("通知流水号:" + seriesNo_);
                                    String json = BcosUtils.hexToUtf8String(getNoticeApi().geIDCNotice(seriesNo_.getBytes()));
                                    System.out.println("通知内容:" + json);

                                    NuccIdcNotice notice = new NuccIdcNotice();
                                    notice.setContentJson(json);
                                    notice.setCreateDate(new Date());
                                    notice.setSeriesNo(seriesNo_);
                                    notice.setNoticeStatus("00");
                                    nuccIdcNoticeMapper.insert(notice);

                                    EpccTradeDto<EpccTradeOpCntDto> dto = (EpccTradeDto<EpccTradeOpCntDto>) JsonUtils.toObject(json, EpccTradeDto.class);
                                    System.out.println("转换实体:" + JsonUtils.toJson(dto));
                                    System.out.println("通知条数:" + dto.getData().getCntList().size());
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
                                            opNotice.setContent(cntDto.getContent());
                                            opNotice.setDesc(cntDto.getDesc());
                                            opNotice.setContacts(cntDto.getContacts());
                                            opNotice.setIdclist(cntDto.getIdcList());
                                            opNotice.setBizChan(cntDto.getCtnNo());
                                            opNotice.setBizTypeList(StringUtils.join(cntDto.getBizTypeList()));
                                            opNotice.setAccType(StringUtils.join(cntDto.getAccType()));
                                            opNotice.setOpList(JsonUtils.toJson(cntDto.getOpList()));

                                            opNotice.setStarttime(cntDto.getStartTime());
                                            opNotice.setEndtime(cntDto.getEndTime());

                                            nuccIdcOpNoticeMapper.insert(opNotice);
                                        } catch (Exception e) {
                                            e.printStackTrace();
                                        }
                                    }
                                } catch (ContractException e) {
                                    // TODO Auto-generated catch block
                                    e.printStackTrace();
                                }
                            }

                        } catch (ABICodecException e) {
                            e.printStackTrace();
                        }
                    }
                }

            }
        });
    }

    @PostConstruct
    public void init() {
        sub();
    }
}
