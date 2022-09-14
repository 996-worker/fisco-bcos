package com.post.epcc.dto.component;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

/**
 * 机构-建议操作实体
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class EpccTradeOpDto {

    //建议支付机构操作 01-保持关注；02-关闭渠道；03-切流至其他机房；
    private String payOp;
    //建议银行操作 01-保持关注；02-关闭渠道；03-切流至其他机房；
    private String bankOp;
    //建议网联操作 01-保持关注；02-关闭渠道；03-切流至其他机房；
    private String netsOp;


}
