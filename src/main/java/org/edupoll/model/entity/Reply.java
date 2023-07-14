package org.edupoll.model.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;

@Entity
@Table(name = "REPLYS")
public class Reply {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	
	String text;
	
	LocalDateTime dates;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "moimId")
	Moim moim;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "userId")
	User user;
	
	public Reply() {
		super();
	}

	public Reply(String text, Moim moim, User user) {
		super();
		this.text = text;
		this.moim = moim;
		this.user = user;
	}

	public LocalDateTime getDates() {
		return dates;
	}

	public void setDates(LocalDateTime dates) {
		this.dates = dates;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
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
	
	@PrePersist
	void prePersist() {
		this.dates = LocalDateTime.now();
	}
}
