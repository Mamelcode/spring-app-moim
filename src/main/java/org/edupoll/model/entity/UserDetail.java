package org.edupoll.model.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user_details")
public class UserDetail {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Integer idx;
	String address;
	Date birthday;
	String description;
	
	@ManyToOne
	@JoinColumn(name = "avatarId")
	Avatar avatar;

	public UserDetail() {
		super();
	}

	public UserDetail(Integer idx, String address, Date birthday, String description, Avatar avatar) {
		super();
		this.idx = idx;
		this.address = address;
		this.birthday = birthday;
		this.description = description;
		this.avatar = avatar;
	}

	@Override
	public String toString() {
		return "UserDetail [idx=" + idx + ", address=" + address + ", birthday=" + birthday + ", description="
				+ description + ", avatar=" + avatar.toString() + "]";
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
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
}
