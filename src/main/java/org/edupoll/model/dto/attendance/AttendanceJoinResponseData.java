package org.edupoll.model.dto.attendance;

import org.edupoll.model.entity.User;

public class AttendanceJoinResponseData {
	
	String userId;
	String nick;
	String avatarURL;
	
	public AttendanceJoinResponseData() {
		super();
	}
	
	public AttendanceJoinResponseData(User user) {
		super();
		this.userId = user.getId();
		this.nick = user.getNick();
		
		if(user.getUserDetail() != null) {
			if(user.getUserDetail().getAvatar() != null) {
				this.avatarURL = user.getUserDetail().getAvatar().getUrl();
			}
		}
	}
	
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
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
