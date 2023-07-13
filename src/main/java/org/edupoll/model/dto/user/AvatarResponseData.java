package org.edupoll.model.dto.user;

import org.edupoll.model.entity.Avatar;

public class AvatarResponseData {

	String id;
	
	String description;
	
	String url;
	
	boolean myAvatar;
	
	public AvatarResponseData() {
		super();
	}

	public AvatarResponseData(Avatar avatar) {
		super();
		this.id = avatar.getId();
		this.description = avatar.getDescription();
		this.url = avatar.getUrl();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public boolean isMyAvatar() {
		return myAvatar;
	}

	public void setMyAvatar(boolean myAvatar) {
		this.myAvatar = myAvatar;
	}
}
