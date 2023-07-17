package org.edupoll.model.dto.mypage;

import java.time.format.DateTimeFormatter;

import org.edupoll.model.entity.Reply;

public class MyReplyData {
	Integer id;
	String text;
	String formatDate;
	String moimId;
	String moimManager;
	String moimTitle;
	
	
	public MyReplyData() {
		super();
	}
	
	public MyReplyData(Reply reply) {
		super();
		this.id = reply.getId();
		this.text = reply.getText();
		this.formatDate = reply.getDates().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		this.moimTitle = reply.getMoim().getTitle();
		this.moimId = reply.getMoim().getId();
		this.moimManager = reply.getMoim().getManager().getNick();
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getFormatDate() {
		return formatDate;
	}
	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}
	public String getMoimId() {
		return moimId;
	}
	public void setMoimId(String moimId) {
		this.moimId = moimId;
	}
	public String getMoimManager() {
		return moimManager;
	}
	public void setMoimManager(String moimManager) {
		this.moimManager = moimManager;
	}
	public String getMoimTitle() {
		return moimTitle;
	}
	public void setMoimTitle(String moimTitle) {
		this.moimTitle = moimTitle;
	}
}
