package org.edupoll.model.dto.user;

import org.edupoll.model.entity.User;

public class UserResponseData {
	String id;
	String nick;
	String avatarURL;
		
	public UserResponseData() {
		super();
	}
	
	public UserResponseData(User user) {
		super();
		this.id = user.getId();
		this.nick = user.getNick();
		if(user.getUserDetail() != null) {
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
	public String getAvatarURL() {
		return avatarURL;
	}
	public void setAvatarURL(String avatarURL) {
		this.avatarURL = avatarURL;
	}
}
