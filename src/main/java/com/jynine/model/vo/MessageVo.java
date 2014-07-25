package com.jynine.model.vo;

import java.util.Date;

/**
 * <p>文件名称 : MessageVo.java</p>
 * <p>文件描述 : 无 </p>
 * <p>内容摘要 : 无</p>
 * <p>其他说明 : 无</p>
 * <p>完成日期 : 2014年7月21日 下午2:57:39</p>
 * @author 李文军
 */
public class MessageVo {
	private Integer msgId;
	private String title;
	private String content;
	private Date time;
	private Integer sendId;
	private String sendName;
	private Integer reciId;
	private String reciName;
	private Integer status;
	private Integer type;
	public Integer getMsgId() {
		return msgId;
	}
	public void setMsgId(Integer msgId) {
		this.msgId = msgId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getSendId() {
		return sendId;
	}
	public void setSendId(Integer sendId) {
		this.sendId = sendId;
	}
	public String getSendName() {
		return sendName;
	}
	public void setSendName(String sendName) {
		this.sendName = sendName;
	}
	public Integer getReciId() {
		return reciId;
	}
	public void setReciId(Integer reciId) {
		this.reciId = reciId;
	}
	public String getReciName() {
		return reciName;
	}
	public void setReciName(String reciName) {
		this.reciName = reciName;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public Integer getType() {
		return type;
	}
	public void setType(Integer type) {
		this.type = type;
	}
}
