package com.post.entity;

public class NuccIdcOpNotice {
    private String recId;

    private String cntNo;

    private String infoNo;

    private String infoType;

    private String instId;

    private String accType;

    private String instName;

    private String content;

    private String desc;

    private String contacts;

    private String idclist;

    private String bizChan;

    private String bizTypeList;

    private String opList;

    private String starttime;

    private String endtime;

    public NuccIdcOpNotice(String recId, String cntNo, String infoNo, String infoType, String instId, String accType, String instName, String content, String desc, String contacts, String idclist, String bizChan, String bizTypeList, String opList, String starttime, String endtime) {
        this.recId = recId;
        this.cntNo = cntNo;
        this.infoNo = infoNo;
        this.infoType = infoType;
        this.instId = instId;
        this.accType = accType;
        this.instName = instName;
        this.content = content;
        this.desc = desc;
        this.contacts = contacts;
        this.idclist = idclist;
        this.bizChan = bizChan;
        this.bizTypeList = bizTypeList;
        this.opList = opList;
        this.starttime = starttime;
        this.endtime = endtime;
    }

    public NuccIdcOpNotice() {
        super();
    }

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId == null ? null : recId.trim();
    }

    public String getCntNo() {
        return cntNo;
    }

    public void setCntNo(String cntNo) {
        this.cntNo = cntNo == null ? null : cntNo.trim();
    }

    public String getInfoNo() {
        return infoNo;
    }

    public void setInfoNo(String infoNo) {
        this.infoNo = infoNo == null ? null : infoNo.trim();
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType == null ? null : infoType.trim();
    }

    public String getInstId() {
        return instId;
    }

    public void setInstId(String instId) {
        this.instId = instId == null ? null : instId.trim();
    }

    public String getAccType() {
        return accType;
    }

    public void setAccType(String accType) {
        this.accType = accType == null ? null : accType.trim();
    }

    public String getInstName() {
        return instName;
    }

    public void setInstName(String instName) {
        this.instName = instName == null ? null : instName.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc == null ? null : desc.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getIdclist() {
        return idclist;
    }

    public void setIdclist(String idclist) {
        this.idclist = idclist == null ? null : idclist.trim();
    }

    public String getBizChan() {
        return bizChan;
    }

    public void setBizChan(String bizChan) {
        this.bizChan = bizChan == null ? null : bizChan.trim();
    }

    public String getBizTypeList() {
        return bizTypeList;
    }

    public void setBizTypeList(String bizTypeList) {
        this.bizTypeList = bizTypeList == null ? null : bizTypeList.trim();
    }

    public String getOpList() {
        return opList;
    }

    public void setOpList(String opList) {
        this.opList = opList == null ? null : opList.trim();
    }

    public String getStarttime() {
        return starttime;
    }

    public void setStarttime(String starttime) {
        this.starttime = starttime == null ? null : starttime.trim();
    }

    public String getEndtime() {
        return endtime;
    }

    public void setEndtime(String endtime) {
        this.endtime = endtime == null ? null : endtime.trim();
    }
}