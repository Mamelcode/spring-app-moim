package org.edupoll.model.dto.search;

import java.time.format.DateTimeFormatter;

import org.edupoll.model.entity.User;

public class SearchUserResponseData {
	String userId; //아이디
	String userNick; //닉네임
	String avatarURL; //아바타이미지
	String description; //한줄소개
	String address; //사는곳
	String birthday; //생일
		
	boolean followed; //팔로우를 했는지 안했는지
	boolean me;

	public SearchUserResponseData() {
		super();
	}

	public SearchUserResponseData(User user) {
		super();
		this.userId = user.getId();
		this.userNick = user.getNick();
		
		if(user.getUserDetail() != null) {
			this.birthday = user.getUserDetail().getBirthday().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
			this.address = user.getUserDetail().getAddress();
			this.description = user.getUserDetail().getDescription();
			this.avatarURL = user.getUserDetail().getAvatar().getUrl();
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

	public boolean isFollowed() {
		return followed;
	}

	public void setFollowed(boolean followed) {
		this.followed = followed;
	}

	public boolean isMe() {
		return me;
	}

	public void setMe(boolean me) {
		this.me = me;
	}
}
