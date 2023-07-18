package org.edupoll.model.dto.mypage;

import java.time.format.DateTimeFormatter;

import org.edupoll.model.entity.Follow;

public class MyFollowData {
	
	Integer id; //팔로우테이블 기본키
	String created; //팔로우한날짜
	
	String userId; //아이디
	String userNick; //닉네임
	String avatarURL; //아바타이미지
	String description; //한줄소개
	String address; //사는곳
	String birthday; //생일
	
	
	
	public MyFollowData() {
		super();
	}
	
	public MyFollowData(Follow follow) {
		super();
		this.id = follow.getId();
		this.created = follow.getCreated().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		
		this.userId = follow.getTarget().getId();
		this.userNick = follow.getTarget().getNick();
		
		if(follow.getTarget().getUserDetail() != null) {
			this.birthday = follow.getTarget().getUserDetail().getBirthday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			this.address = follow.getTarget().getUserDetail().getAddress();
			this.description = follow.getTarget().getUserDetail().getDescription();
			this.avatarURL = follow.getTarget().getUserDetail().getAvatar().getUrl();
		}
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserNick() {
		return userNick;
	}
	public void setUserNick(String userNick) {
		this.userNick = userNick;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCreated() {
		return created;
	}
	public void setCreated(String created) {
		this.created = created;
	}
}
