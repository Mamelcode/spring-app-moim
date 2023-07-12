package org.edupoll.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.edupoll.model.dto.moim.AttendanceJoinResponseData;
import org.edupoll.model.dto.moim.AttendanceRequestData;
import org.edupoll.model.entity.Attendance;
import org.edupoll.model.entity.Moim;
import org.edupoll.model.entity.User;
import org.edupoll.repository.AttendanceRepository;
import org.edupoll.repository.MoimRepository;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class AttendanceService {
	
	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MoimRepository moimRepository;
	
	
	// 모임 참가 신청
	@Transactional
	public AttendanceJoinResponseData createAttendance(AttendanceRequestData attendanceData) {
		AttendanceJoinResponseData data = new AttendanceJoinResponseData();
		
		Optional<User> user = userRepository.findById(attendanceData.getUserId());
		Optional<Moim> moim = moimRepository.findById(attendanceData.getMoimId()); 
		
		if(user.isEmpty() || moim.isEmpty()) {
			data.setResult(false);
			data.setErrorMessage("유효하지 않은 정보가 전송되었습니다.");
			return data;
		}
		if(attendanceRepository.existsByUserIdIsAndMoimIdIs
				(attendanceData.getUserId(), attendanceData.getMoimId())) {
			data.setResult(false);
			data.setErrorMessage("이미 참가중인 모임 입니다.");
			return data;
		}
		
		if(moim.get().getCurrentPerson() >= moim.get().getMaxPerson()) {
			data.setResult(false);
			data.setErrorMessage("최대 허용 인원을 초과하였습니다.");
			return data;
		}
		Attendance attendance = new Attendance(moim.get(), user.get());
		attendanceRepository.save(attendance);
		
		moim.get().setCurrentPerson(moim.get().getCurrentPerson()+1);
		moimRepository.save(moim.get());
		
		data.setResult(true);
		data.setCurrentPerson(moim.get().getCurrentPerson());
		List<String> list = new ArrayList<>();
		for(Attendance a : attendanceRepository.findByMoimIdIs(attendanceData.getMoimId())) {
			list.add(a.getUser().getId());
		}
		data.setAttendUserIds(list);
		
		/*
		attendanceRepository.findByMoimIdIs(
				attendanceData.getMoimId()).stream().map(e -> e.getUser().getId()
		).toList();
		*/
		
		return data;
	}
	
	// 모임 참가 삭제
	@Transactional
	public AttendanceJoinResponseData deleteAttendance(AttendanceRequestData reqData) {
		AttendanceJoinResponseData respData = new AttendanceJoinResponseData();
		
		
		attendanceRepository.removeByUserIdIsAndMoimIdIs(reqData.getUserId(), reqData.getMoimId());
		
		Optional<Moim> moim = moimRepository.findById(reqData.getMoimId()); 
		
		moim.get().setCurrentPerson(moim.get().getCurrentPerson()-1);
		moimRepository.save(moim.get());
		
		respData.setResult(true);
		respData.setCurrentPerson(moim.get().getCurrentPerson());
		List<String> list = new ArrayList<>();
		for(Attendance a : attendanceRepository.findByMoimIdIs(reqData.getMoimId())) {
			list.add(a.getUser().getId());
		}
		respData.setAttendUserIds(list);
		
		return respData;
	}
	
	// 특정 유저가 모임에 참여 중인지?
	public boolean isJoined(String userId, String moimId) {
		return attendanceRepository.existsByUserIdIsAndMoimIdIs(userId, moimId);
	}
	
}
