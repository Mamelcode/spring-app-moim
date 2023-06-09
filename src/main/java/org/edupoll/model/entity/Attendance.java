package org.edupoll.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "ATTENDANCES")
public class Attendance {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "moimId")
	Moim moim;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	User user;
	
	public Attendance() {
		super();
	}
	
	public Attendance(Moim moim, User user) {
		super();
		this.moim = moim;
		this.user = user;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Moim getMoim() {
		return moim;
	}

	public void setMoim(Moim moim) {
		this.moim = moim;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
}
