package org.edupoll.model.dto.mypage;

import java.time.format.DateTimeFormatter;

import org.edupoll.model.entity.Moim;

public class MyCreatorMoimData {
	
	String moimId;
	String managerId;
	
	String nick;
	
	String title;
	String cate;
	String description;
	
	Integer maxPerson;
	Integer currentPerson;
	
	String formatDate;
	
	String timeStart;
	String timeEnd;
	
	
	public MyCreatorMoimData() {
		super();
	}
	
	// 모임 리스트 찍는 생성자
	public MyCreatorMoimData(Moim moim) {
		this.moimId = moim.getId();
		this.nick = moim.getManager().getNick();
		this.managerId = moim.getManager().getId();
		if(moim.getTitle().length() > 10) {
			this.title = moim.getTitle().substring(0,10)+"...";
		}else {
			this.title = moim.getTitle();
		}
		this.cate = moim.getCate();
		this.description = moim.getDescription();
		this.maxPerson = moim.getMaxPerson();
		this.currentPerson = moim.getCurrentPerson();		
		this.formatDate = moim.getTargetDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.timeStart = moim.getTargetDate().format(DateTimeFormatter.ofPattern("HH:mm")); 
		this.timeEnd = moim.getDuration().format(DateTimeFormatter.ofPattern("HH:mm"));
	}
	
	public String getMoimId() {
		return moimId;
	}
	public void setMoimId(String moimId) {
		this.moimId = moimId;
	}
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
	}
	public String getNick() {
		return nick;
	}
	public void setNick(String nick) {
		this.nick = nick;
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
	public String getFormatDate() {
		return formatDate;
	}
	public void setFormatDate(String formatDate) {
		this.formatDate = formatDate;
	}
	public String getTimeStart() {
		return timeStart;
	}
	public void setTimeStart(String timeStart) {
		this.timeStart = timeStart;
	}
	public String getTimeEnd() {
		return timeEnd;
	}
	public void setTimeEnd(String timeEnd) {
		this.timeEnd = timeEnd;
	}
}

