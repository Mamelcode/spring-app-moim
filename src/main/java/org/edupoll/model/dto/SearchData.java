package org.edupoll.model.dto;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.edupoll.model.entity.User;

public class SearchData {
	String id;
	String nick;
	String address;
	String avatarURL;
	String description;
	
	Integer userDetailId;
	
	String joinDate;
	String birthday;
	
	
	public SearchData() {
		super();
	}
	
	public SearchData(User user) {
		this.id = user.getId();
		this.nick = user.getNick();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if(user.getJoinDate() != null)
			this.joinDate = sdf.format(user.getJoinDate());
		
		if(user.getUserDetail() != null) {
			this.userDetailId = user.getUserDetail().getIdx();
			this.address = user.getUserDetail().getAddress();
			this.description = user.getUserDetail().getDescription();
			
			if(user.getUserDetail().getBirthday() != null)
				this.birthday = sdf.format(user.getUserDetail().getBirthday());
			
			if(user.getUserDetail().getAvatar() != null)
				this.avatarURL = user.getUserDetail().getAvatar().getUrl();
		}
		
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAvatarURL() {
		return avatarURL;
	}
	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Integer getUserDetailId() {
		return userDetailId;
	}
	public void setUserDetailId(Integer userDetailId) {
		this.userDetailId = userDetailId;
	}
	public String getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(String joinDate) {
		this.joinDate = joinDate;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
}
