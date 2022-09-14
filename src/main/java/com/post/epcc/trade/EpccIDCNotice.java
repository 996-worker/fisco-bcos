package com.post.epcc.trade;

import com.post.epcc.dto.EpccTradeDataDto;
import lombok.Data;

@Data
/**
 * 机房变通通知-公共报文
 */
public class EpccIDCNotice<T> {
    //报文内容
    private EpccTradeDataDto<T> data;
    //报文方向 01:网联平台到银行 02:网联平台到支付机构 10:银行到网联平台 20:支付机构到网联平台
    private String drctn;
    //报文标识
    private String msgId;
    //报文编号
    private String msgTp;
    //接受机构标志
    private String reIssrId;
    //系统标识
    private String reqSysId;

}
