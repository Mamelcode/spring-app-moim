package org.edupoll.model.dto.moim;

import java.time.format.DateTimeFormatter;
import java.util.List;

import org.edupoll.model.dto.attendance.AttendanceJoinResponseData;
import org.edupoll.model.dto.reply.ReplyPageResponseData;
import org.edupoll.model.dto.user.UserResponseData;
import org.edupoll.model.entity.Moim;

public class MoimDetailResponseData {
	
	String id;
	String managerId;
	
	String title;
	String cate;
	String description;
	
	Integer maxPerson;
	Integer currentPerson;
	
	String formatDate;
	
	String timeStart;
	String timeEnd; 
	
	UserResponseData manager;
	
	ReplyPageResponseData pageReply;
	
	List<AttendanceJoinResponseData> attendace;
	
	
	boolean ismaxPerson;
	boolean isJoined;
	boolean isCreator;
	
	
	public MoimDetailResponseData() {
		super();
	}

	public MoimDetailResponseData(UserResponseData manager, Moim moim, ReplyPageResponseData pageReply, 
			boolean isJoined, boolean isCreator, boolean ismaxPerson, 
			List<AttendanceJoinResponseData> attendace) {
		super();
		this.manager = manager;
		this.id = moim.getId();
		this.managerId = moim.getManager().getId();
		this.title = moim.getTitle();
		this.cate = moim.getCate();
		this.description = moim.getDescription();
		this.maxPerson = moim.getMaxPerson();
		this.currentPerson = moim.getCurrentPerson();		
		this.formatDate = moim.getTargetDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
		this.timeStart = moim.getTargetDate().format(DateTimeFormatter.ofPattern("HH:mm")); 
		this.timeEnd = moim.getDuration().format(DateTimeFormatter.ofPattern("HH:mm"));
		this.pageReply = pageReply;
		this.isJoined = isJoined;
		this.isCreator = isCreator;
		this.ismaxPerson = ismaxPerson;
		this.attendace = attendace;
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

	public ReplyPageResponseData getPageReply() {
		return pageReply;
	}

	public void setPageReply(ReplyPageResponseData pageReply) {
		this.pageReply = pageReply;
	}

	public boolean isJoined() {
		return isJoined;
	}

	public void setJoined(boolean isJoined) {
		this.isJoined = isJoined;
	}

	public boolean isCreator() {
		return isCreator;
	}

	public void setCreator(boolean isCreator) {
		this.isCreator = isCreator;
	}

	public boolean isIsmaxPerson() {
		return ismaxPerson;
	}

	public void setIsmaxPerson(boolean ismaxPerson) {
		this.ismaxPerson = ismaxPerson;
	}

	public List<AttendanceJoinResponseData> getAttendace() {
		return attendace;
	}

	public void setAttendace(List<AttendanceJoinResponseData> attendace) {
		this.attendace = attendace;
	}
	
}
