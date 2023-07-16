package org.edupoll.model.entity;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

import org.edupoll.model.dto.moim.MoimModifyRequestData;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "MOIMS")
public class Moim {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String id;
	
	String title;
	String cate;
	String description;
	
	Integer maxPerson;
	Integer currentPerson;
	LocalTime duration;
	
	LocalDateTime targetDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "managerId")
	User manager;
	
	@OneToMany(mappedBy = "moim", fetch = FetchType.LAZY)
	List<Reply> replys;
	
	@OneToMany(mappedBy = "moim", fetch = FetchType.LAZY)
	List<Attendance> attendances;
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMaxPerson() {
		return maxPerson;
	}

	public void setMaxPerson(Integer maxPerson) {
		this.maxPerson = maxPerson;
	}

	public Integer getCurrentPerson() {
		return currentPerson;
	}

	public void setCurrentPerson(Integer currentPerson) {
		this.currentPerson = currentPerson;
	}
	
	public User getManager() {
		return manager;
	}

	public void setManager(User manager) {
		this.manager = manager;
	}

	public List<Reply> getReplys() {
		return replys;
	}

	public void setReplys(List<Reply> replys) {
		this.replys = replys;
	}

	public List<Attendance> getAttendances() {
		return attendances;
	}

	public void setAttendances(List<Attendance> attendances) {
		this.attendances = attendances;
	}

	public LocalTime getDuration() {
		return duration;
	}

	public void setDuration(LocalTime duration) {
		this.duration = duration;
	}

	public LocalDateTime getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(LocalDateTime targetDate) {
		this.targetDate = targetDate;
	}
}
