package org.edupoll.model.dto.user;

import java.util.Date;

public class UserDetailResponseData {
	
	Integer idx;
	
	String description;
	
	String address;
	
	String avatarId;
	
	Date birthday;
	
	public Integer getIdx() {
		return idx;
	}
	public void setIdx(Integer idx) {
		this.idx = idx;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
}
