package org.edupoll.model.dto.search;

import java.time.format.DateTimeFormatter;

import org.edupoll.model.entity.Moim;

public class SearchMoimResponseData {

	String id; //기본키
	String managerId; //주최자아이디 	
	String nick; //주최자닉네임
	String title; //모임제목
	String cate; //모임카테고리
	String description; //모임설명
	Integer maxPerson; //최대 참가인원
	Integer currentPerson; //현재 참가인원
	String formatDate; //모임일
	String timeStart; //모임시작시간
	String timeEnd; //모임종료시간
	
	public SearchMoimResponseData() {
		super();
	}
	
	// 모임 리스트 찍는 생성자
	public SearchMoimResponseData(Moim moim) {
		super();
		this.id = moim.getId();
		this.nick = moim.getManager().getNick();
		this.managerId = moim.getManager().getId();
		this.title = moim.getTitle();
		this.cate = moim.getCate();
		this.description = moim.getDescription();
		this.maxPerson = moim.getMaxPerson();
		this.currentPerson = moim.getCurrentPerson();		
		this.formatDate = moim.getTargetDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.timeStart = moim.getTargetDate().format(DateTimeFormatter.ofPattern("HH:mm")); 
		this.timeEnd = moim.getDuration().format(DateTimeFormatter.ofPattern("HH:mm"));
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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
