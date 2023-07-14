package org.edupoll.model.entity;

import java.util.Date;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	
	String authority;

	@OneToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "USER_DETAIL_IDX") // User Entity의 필드
	UserDetail userDetail; // 이 컬럼을 이용해서 찾는 UserDetail(idx기준)
	
	@OneToMany(mappedBy = "manager", fetch = FetchType.LAZY)
	List<Moim> moim;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	List<Attendance> attendances;
	
	@OneToMany(mappedBy = "owner", fetch = FetchType.LAZY)
	List<Follow> followTo;
	
	@OneToMany(mappedBy = "target", fetch =  FetchType.LAZY)
	List<Follow> followFrom;
	
	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
	List<Reply> replies;
	
	public User() {
		super();
	}

	public User(String id, String pass, String nick, String authority) {
		super();
		this.id = id;
		this.pass = pass;
		this.nick = nick;
		this.authority = authority;
	}

	// set / get
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

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}
	
	public List<Moim> getMoim() {
		return moim;
	}

	public void setMoim(List<Moim> moim) {
		this.moim = moim;
	}
	
	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public List<Follow> getFollowTo() {
		return followTo;
	}

	public void setFollowTo(List<Follow> followTo) {
		this.followTo = followTo;
	}

	public List<Follow> getFollowFrom() {
		return followFrom;
	}

	public void setFollowFrom(List<Follow> followFrom) {
		this.followFrom = followFrom;
	}
	
	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
	public List<Reply> getReplies() {
		return replies;
	}

	public void setReplies(List<Reply> replies) {
		this.replies = replies;
	}

	// 객체 insert 전 할 작업
	@PrePersist
	public void doPrepersist() {
		joinDate = new Date();
	}
}
