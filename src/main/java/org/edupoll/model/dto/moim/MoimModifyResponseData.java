package org.edupoll.model.dto.moim;

import java.time.format.DateTimeFormatter;

import org.edupoll.model.entity.Moim;

public class MoimModifyResponseData {
	
	String id;
	
	String title;
	String cate;
	String description;
	
	Integer maxPerson;
	Integer currentPerson;
	
	String duration;
	String targetDate;
	
	public MoimModifyResponseData() {
		super();
	}

	public MoimModifyResponseData(Moim moim) {
		super();
		this.id = moim.getId();
		this.title = moim.getTitle();
		this.cate = moim.getCate();
		this.description = moim.getDescription();
		this.maxPerson = moim.getMaxPerson();
		this.currentPerson = moim.getCurrentPerson();
		this.duration = moim.getDuration().format(DateTimeFormatter.ofPattern("HH:mm"));
		this.targetDate = moim.getTargetDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
	}
	
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
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public String getTargetDate() {
		return targetDate;
	}
	public void setTargetDate(String targetDate) {
		this.targetDate = targetDate;
	}
}
