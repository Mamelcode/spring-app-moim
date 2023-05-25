package org.edupoll.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@Column(name = "ID")
	String id;
	
	@Column(name = "PASS")
	String pass;
	
	@Column(name = "NICK")
	String nick;
	
	@Column(name = "JOIN_DATE")
	Date joinDate;
	
	@Column(name = "USER_DETAIL_IDX")
	Integer userDetailId;
	
	public User() {
		super();
	}
	
	public User(String id, String pass, String nick, Date joinDate, Integer userDetailId) {
		super();
		this.id = id;
		this.pass = pass;
		this.nick = nick;
		this.joinDate = joinDate;
		this.userDetailId = userDetailId;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	public Date getJoinDate() {
		return joinDate;
	}

	public void setJoinDate(Date joinDate) {
		this.joinDate = joinDate;
	}

	public Integer getUserDetailId() {
		return userDetailId;
	}

	public void setUserDetailId(Integer userDetailId) {
		this.userDetailId = userDetailId;
	}

	@PrePersist
	public void doPrepersist() {
		System.out.println("doPrepersist");
		joinDate = new Date();
	}
}
