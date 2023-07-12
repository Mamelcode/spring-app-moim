package org.edupoll.model.dto.user;

public class LoginRequestData {
	String loginId;
	String loginPass;
	
	public LoginRequestData() {
	}
	public LoginRequestData(String loginId, String loginPass) {
		this.loginId = loginId;
		this.loginPass = loginPass;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	public String getLoginPass() {
		return loginPass;
	}
	public void setLoginPass(String loginPass) {
		this.loginPass = loginPass;
	}
}
