package com.post.entity;

import java.util.Date;

public class NuccIdcNotice {
    private String seriesNo;

    private String contentJson;

    private Date createDate;

    private String noticeStatus;

    public NuccIdcNotice(String seriesNo, String contentJson, Date createDate, String noticeStatus) {
        this.seriesNo = seriesNo;
        this.contentJson = contentJson;
        this.createDate = createDate;
        this.noticeStatus = noticeStatus;
    }

    public NuccIdcNotice() {
        super();
    }

    public String getSeriesNo() {
        return seriesNo;
    }

    public void setSeriesNo(String seriesNo) {
        this.seriesNo = seriesNo == null ? null : seriesNo.trim();
    }

    public String getContentJson() {
        return contentJson;
    }

    public void setContentJson(String contentJson) {
        this.contentJson = contentJson == null ? null : contentJson.trim();
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getNoticeStatus() {
        return noticeStatus;
    }

    public void setNoticeStatus(String noticeStatus) {
        this.noticeStatus = noticeStatus == null ? null : noticeStatus.trim();
    }
}