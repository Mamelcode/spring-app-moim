package org.edupoll.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.edupoll.model.dto.attendance.AttendanceJoinResponseData;
import org.edupoll.model.dto.attendance.AttendanceRequestData;
import org.edupoll.model.entity.Attendance;
import org.edupoll.model.entity.Moim;
import org.edupoll.model.entity.User;
import org.edupoll.repository.AttendanceRepository;
import org.edupoll.repository.MoimRepository;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


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
	public int createAttendance(String moimId, String userId) {
		
		Optional<User> user = userRepository.findById(userId);
		Optional<Moim> moim = moimRepository.findById(moimId); 
		
		// 이미 참가중 실패!
		if(attendanceRepository.existsByUserIdIsAndMoimIdIs
				(userId, moimId)) {
			return 1;
		}
		
		// 정원초과 실패!
		if(moim.get().getCurrentPerson() >= moim.get().getMaxPerson()) {
			return 2;
		}
		
		// 참가신청 save
		Attendance attendance = new Attendance(moim.get(), user.get());
		attendanceRepository.save(attendance);
		
		// 참가인원 +1
		moim.get().setCurrentPerson(moim.get().getCurrentPerson()+1);
		moimRepository.save(moim.get());
						
		return 0;
	}
	
	// 모임 참가 삭제
	@Transactional
	public boolean deleteAttendance(String moimId, String userId) {
		Optional<Moim> moim = moimRepository.findById(moimId);
		if(moim.isEmpty()) {
			return false;
		}
		
		// 참가취소
		attendanceRepository.removeByUserIdIsAndMoimIdIs(userId, moimId);
		
		// 모임 참가자 -1
		moim.get().setCurrentPerson(moim.get().getCurrentPerson()-1);
				
		return true;
	}
	
	// 특정 유저가 모임에 참여 중인지?
	public boolean isJoined(String userId, String moimId) {
		return attendanceRepository.existsByUserIdIsAndMoimIdIs(userId, moimId);
	}
	
}
