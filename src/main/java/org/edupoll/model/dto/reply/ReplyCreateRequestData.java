package org.edupoll.model.dto.reply;

public class ReplyCreateRequestData {
	String moimId;
	String text;
	
	public String getMoimId() {
		return moimId;
	}
	public void setMoimId(String moimId) {
		this.moimId = moimId;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
