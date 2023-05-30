package org.edupoll.model.entity;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
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

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_DETAIL_IDX") // User Entity의 필드
	UserDetail userDetail; // 이 컬럼을 이용해서 찾는 UserDetail(idx기준)

	// set / get
	public String getId() {
		return id;
	}

	// toString
	@Override
	public String toString() {
		return "User [id=" + id + ", pass=" + pass + ", nick=" + nick + ", joinDate=" + joinDate + ", userDetail="
				+ userDetail.toString() + "]";
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

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	// 객체 insert 전 할 작업
	@PrePersist
	public void doPrepersist() {
		System.out.println("doPrepersist");
		joinDate = new Date();
	}
}
