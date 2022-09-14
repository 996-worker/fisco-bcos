package com.post.epcc.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.post.epcc.dto.component.EpccTradeOpDto;
import lombok.Data;

import java.util.List;

/**
 * 机房变通通知-通知实体
 */
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_NULL)
public class EpccTradeOpCntDto {
    //信息序号
    private String ctnNo;
    //运维编号
    private String infoNo;
    //成员单位金融机构代码
    private String instId;
    //信息类型 01-生产维护，02-生产变更，03-生产上线，04-生产压测，05-生产演练，06-其他；
    private String infoType;
    //成员单位名称
    private String instName;
    //建议操作列表
    private List<EpccTradeOpDto> opList;
    //计划开始时间
    private String startTime;
    //计划结束时间
    private String endTime;
    //影响业务类型集合
    private String[] bizTypeList;
    //影响账户类型
    private String[] accType;
    //影响业务渠道
    private String bizChan;
    //影响网联IDC
    private String idcList;
    //影响变更方IDC
    private String idcList2;
    //补充内容
    private String content;
    //影响程度
    private String desc;

    //未按时开始，未按时结束处理方式
    private String overOpera;
    //联系方式
    private String contacts;
    //状态表示 1-新增,2-取消
    private int status;


}
