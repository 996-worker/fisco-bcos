package com.post.entity;

public class NuccIdcOpNotice {
    private String recId;

    private String cntNo;

    private String infoNo;

    private String infoType;

    private String instId;

    private String accType;

    private String instName;

    private String noticeContent;

    private String noticeDesc;

    private String contacts;

    private String idcList;

    private String bizChan;

    private String bizTypeList;

    private String opList;

    private String startTime;

    private String endTime;

    public NuccIdcOpNotice(String recId, String cntNo, String infoNo, String infoType, String instId, String accType, String instName, String noticeContent, String noticeDesc, String contacts, String idcList, String bizChan, String bizTypeList, String opList, String startTime, String endTime) {
        this.recId = recId;
        this.cntNo = cntNo;
        this.infoNo = infoNo;
        this.infoType = infoType;
        this.instId = instId;
        this.accType = accType;
        this.instName = instName;
        this.noticeContent = noticeContent;
        this.noticeDesc = noticeDesc;
        this.contacts = contacts;
        this.idcList = idcList;
        this.bizChan = bizChan;
        this.bizTypeList = bizTypeList;
        this.opList = opList;
        this.startTime = startTime;
        this.endTime = endTime;
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

    public String getNoticeContent() {
        return noticeContent;
    }

    public void setNoticeContent(String noticeContent) {
        this.noticeContent = noticeContent == null ? null : noticeContent.trim();
    }

    public String getNoticeDesc() {
        return noticeDesc;
    }

    public void setNoticeDesc(String noticeDesc) {
        this.noticeDesc = noticeDesc == null ? null : noticeDesc.trim();
    }

    public String getContacts() {
        return contacts;
    }

    public void setContacts(String contacts) {
        this.contacts = contacts == null ? null : contacts.trim();
    }

    public String getIdcList() {
        return idcList;
    }

    public void setIdcList(String idcList) {
        this.idcList = idcList == null ? null : idcList.trim();
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime == null ? null : startTime.trim();
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }
}