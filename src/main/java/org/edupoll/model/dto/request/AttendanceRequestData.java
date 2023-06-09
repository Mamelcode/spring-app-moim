package org.edupoll.model.dto.request;

public class AttendanceRequestData {
	String moimId;
	String userId;
	
	public AttendanceRequestData(String moimId, String userId) {
		super();
		this.moimId = moimId;
		this.userId = userId;
	}
	public String getMoimId() {
		return moimId;
	}
	public void setMoimId(String moimId) {
		this.moimId = moimId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
}
