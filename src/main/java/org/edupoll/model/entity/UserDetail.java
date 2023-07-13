package org.edupoll.model.entity;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.edupoll.model.dto.user.UserDetailReqeustData;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer idx;
	String address;
	LocalDate birthday;
	String description;
	
	@ManyToOne
	@JoinColumn(name = "avatarId")
	Avatar avatar;

	@OneToOne(mappedBy = "userDetail", fetch = FetchType.LAZY)
	User user;
	
	public UserDetail() {
		super();
	}
	
	public UserDetail(UserDetailReqeustData data) {
		super();
		this.address = data.getAddress();
		this.birthday = LocalDate.parse(data.getBirthday(), DateTimeFormatter.ISO_DATE);
		this.description = data.getDescription();
	}

	public Integer getIdx() {
		return idx;
	}

	public void setIdx(Integer idx) {
		this.idx = idx;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Avatar getAvatar() {
		return avatar;
	}

	public void setAvatar(Avatar avatar) {
		this.avatar = avatar;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
