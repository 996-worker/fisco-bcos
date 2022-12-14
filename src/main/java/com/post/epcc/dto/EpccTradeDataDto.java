package com.post.epcc.dto;

import lombok.Data;

import java.util.List;

@Data
/**
 * 机房变通通知-数据实体
 */
public class EpccTradeDataDto<T> {
    //统计数量
    private int cntSumNo;
    //报文方向 01:网联平台到银行 02:网联平台到支付机构 10:银行到网联平台 20:支付机构到网联平台
    private String drctn;
    //报文标识
    private String msgTp;
    //统计数据集合
    private List<T> cntList;


}
