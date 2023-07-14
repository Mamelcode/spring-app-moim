package org.edupoll.model.dto.reply;

import java.time.format.DateTimeFormatter;

import org.edupoll.model.entity.Reply;

public class ReplyResponseData {
	
	Integer Id;
	
	String text;
	
	String dates;
	
	String writer;
	
	String avatarURL;

	public ReplyResponseData() {
		super();
	}
	
	public ReplyResponseData(Reply reply) {
		super();
		Id = reply.getId();
		this.text = reply.getText();
		this.dates = reply.getDates().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
		this.writer = reply.getUser().getNick();
		if(reply.getUser().getUserDetail() != null) {
			this.avatarURL = reply.getUser().getUserDetail().getAvatar().getUrl();
		}
	}
	
	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getDates() {
		return dates;
	}

	public void setDates(String dates) {
		this.dates = dates;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}
}
