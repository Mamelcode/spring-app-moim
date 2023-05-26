package org.edupoll.model.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "MOIMS")
public class Moim {
	@Id
	@GeneratedValue(strategy = GenerationType.UUID)
	String Id;
	String managerId;
	
	String title;
	String cate;
	String description;
	
	Integer maxPerson;
	Integer currentPerson;
	Integer duration;
	
	Date targetDate;
	
	public Moim() {
		super();
	}
	
	public Moim(String id, String managerId, String title, String cate, String description, Integer maxPerson,
			Integer currentPerson, Integer duration, Date targetDate) {
		super();
		Id = id;
		this.managerId = managerId;
		this.title = title;
		this.cate = cate;
		this.description = description;
		this.maxPerson = maxPerson;
		this.currentPerson = currentPerson;
		this.duration = duration;
		this.targetDate = targetDate;
	}

	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public String getManagerId() {
		return managerId;
	}

	public void setManagerId(String managerId) {
		this.managerId = managerId;
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

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}

	public Date getTargetDate() {
		return targetDate;
	}

	public void setTargetDate(Date targetDate) {
		this.targetDate = targetDate;
	}
	
}
