package org.edupoll.model.dto.user;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.edupoll.model.entity.UserDetail;

public class UserDetailResponseData {
	
	Integer idx;
	
	String description;
	
	String address;
	
	String avatarId;
	
	String avatarURL;
	
	String birthday;
	
	List<AvatarResponseData> avatars;
	
	public UserDetailResponseData() {
		super();
	}

	public UserDetailResponseData(UserDetail detail, List<AvatarResponseData> avatars) {
		super();
		this.idx = detail.getIdx();
		this.description = detail.getDescription();
		this.address = detail.getAddress();
		this.avatarId = detail.getAvatar().getId();
		this.avatarURL = detail.getAvatar().getUrl();
		this.birthday = detail.getBirthday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.avatars = avatars;
	}
	
	public UserDetailResponseData(List<AvatarResponseData> avatars) {
		super();
		this.avatars = avatars;
	}

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

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public List<AvatarResponseData> getAvatars() {
		return avatars;
	}

	public void setAvatars(List<AvatarResponseData> avatars) {
		this.avatars = avatars;
	}

	public String getAvatarURL() {
		return avatarURL;
	}

	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}
}
