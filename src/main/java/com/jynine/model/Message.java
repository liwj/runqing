package com.jynine.model;

import java.util.Date;

public class Message {
    private Integer msgId;

    private String msgTitle;

    private String msgContent;

    private Integer msgStatus;

    private Integer msgSendId;

    private Integer msgReciId;

    private Date msgTime;

    public Integer getMsgId() {
        return msgId;
    }

    public void setMsgId(Integer msgId) {
        this.msgId = msgId;
    }

    public String getMsgTitle() {
        return msgTitle;
    }

    public void setMsgTitle(String msgTitle) {
        this.msgTitle = msgTitle == null ? null : msgTitle.trim();
    }

    public String getMsgContent() {
        return msgContent;
    }

    public void setMsgContent(String msgContent) {
        this.msgContent = msgContent == null ? null : msgContent.trim();
    }

    public Integer getMsgStatus() {
        return msgStatus;
    }

    public void setMsgStatus(Integer msgStatus) {
        this.msgStatus = msgStatus;
    }

    public Integer getMsgSendId() {
        return msgSendId;
    }

    public void setMsgSendId(Integer msgSendId) {
        this.msgSendId = msgSendId;
    }

    public Integer getMsgReciId() {
        return msgReciId;
    }

    public void setMsgReciId(Integer msgReciId) {
        this.msgReciId = msgReciId;
    }

    public Date getMsgTime() {
        return msgTime;
    }

    public void setMsgTime(Date msgTime) {
        this.msgTime = msgTime;
    }
}