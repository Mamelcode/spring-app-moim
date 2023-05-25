package org.edupoll.model.dto;

import java.util.Date;

public class SearchData {
	String id;
	String nick;
	String address;
	String avatarId;
	String description;
	
	Integer userDetailId;
	
	Date joinDate;
	Date birthday;
	
	public SearchData() {
		super();
	}
	public SearchData(String id, String nick, String address, String avatarId, String description, Integer userDetailId,
			Date joinDate, Date birthday) {
		super();
		this.id = id;
		this.nick = nick;
		this.address = address;
		this.avatarId = avatarId;
		this.description = description;
		this.userDetailId = userDetailId;
		this.joinDate = joinDate;
		this.birthday = birthday;
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
	public String getAvatarId() {
		return avatarId;
	}
	public void setAvatarId(String avatarId) {
		this.avatarId = avatarId;
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
	public Date getJoinDate() {
		return joinDate;
	}
	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
