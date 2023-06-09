package org.edupoll.service;

import java.util.List;
import java.util.Optional;

import org.edupoll.model.dto.request.AttendanceRequestData;
import org.edupoll.model.entity.Attendance;
import org.edupoll.model.entity.Moim;
import org.edupoll.model.entity.Reply;
import org.edupoll.model.entity.User;
import org.edupoll.repository.AttendanceRepository;
import org.edupoll.repository.MoimRepository;
import org.edupoll.repository.ReplyRepository;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class MoimService {
	
	@Autowired
	MoimRepository moimRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Autowired
	ReplyRepository replyRepository;
	
	// 모임 만들기
	public boolean createMoim(Moim moim, String logonId) {
		User user = userRepository.findById(logonId).get();
		moim.setManager(user);
		Moim create = moimRepository.save(moim);
		
		Attendance at = new Attendance();
		at.setMoim(moim);
		at.setUser(user);
		attendanceRepository.save(at);
		
		return true;
	}
	
	// 모임 페이징처리해서 가져오기
	public List<Moim> findByMoimAll(int page) {
		Sort sort = Sort.by(Direction.ASC, "targetDate");
		
		List<Moim> list = moimRepository.findAll(PageRequest.of(page-1, 9, sort)).toList();
		
		return list;
	}
	
	// 모임 개수 가져오기
	public long countMoim() {
		return moimRepository.count();
	}
	
	// 모임 디테일 가져오기
	public Moim findByMoim(String moimId) {
		Optional<Moim> option = moimRepository.findById(moimId);
		if(option.isEmpty()) {
			return null;
		}
		
		return option.get();
	}
	
	// 모임 삭제
	public boolean deleteByMoim(String moimId) {
		Optional<Moim> moimOption = moimRepository.findById(moimId);
		if(moimOption.isEmpty()) {
			return false;
		}
		
		Moim moim = moimOption.get();
		List<Reply> replys = moim.getReplys();
		List<Attendance> attendancens = moim.getAttendances();
		
		for(Reply r : replys) {
			replyRepository.deleteById(r.getId());
		}
		
		for(Attendance a : attendancens) {
			attendanceRepository.deleteById(a.getId());
		}
		
		moimRepository.delete(moim);
		
		return true;
		
	}
}
