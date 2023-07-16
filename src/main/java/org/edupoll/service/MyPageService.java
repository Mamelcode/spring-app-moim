package org.edupoll.service;

import java.util.ArrayList;
import java.util.List;

import org.edupoll.model.dto.etc.PageData;
import org.edupoll.model.dto.mypage.MyAttendanceMoimData;
import org.edupoll.model.dto.mypage.MyCreatorMoimData;
import org.edupoll.model.dto.mypage.MyPageResponseData;
import org.edupoll.model.entity.Attendance;
import org.edupoll.model.entity.Moim;
import org.edupoll.repository.AttendanceRepository;
import org.edupoll.repository.MoimRepository;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class MyPageService {

	@Autowired
	AttendanceRepository attendanceRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	MoimRepository moimRepository;
	
	// 참여목록 가져오기
	public MyPageResponseData getAttendanceMoims(String userId, int page) {
		Sort sort = Sort.by(Direction.ASC, "id");
		
		List<Attendance> list = attendanceRepository.findByUserIdIs(PageRequest.of(page-1, 10, sort), userId);
		if(list.isEmpty()) {
			return null;
		}
		
		// 화면 페이징처리를 계산한다.
		int total = (int)attendanceRepository.countByUserId(userId);
		int totalPage = total/10 + (total % 10 > 0 ? 1: 0);
		int viewPage = 5;
		int endPage = (((page-1)/viewPage)+1) * viewPage;
		int nextPage = 0;
		
		if(totalPage < endPage) {
		    endPage = totalPage;
		}
		int startPage = ((page-1)/viewPage) * viewPage + 1;
		
		int idx = Math.round(startPage / viewPage)+1;
		
		List<PageData> pages = new ArrayList<>();
		for(int i=startPage; i<=5*idx; i++) {
			pages.add(new PageData(String.valueOf(i), page == i));
			if(i == totalPage) {
				nextPage = i+1;
				break;
			}
			nextPage = i+1;
		}
				
		boolean existPrev = page >= 6;
		boolean existNext = true;
		if(endPage >= totalPage)
		{
			existNext = false;
		}
		
		List<MyAttendanceMoimData> datas = list.stream().map(MyAttendanceMoimData::new).toList();
		MyPageResponseData respData = new MyPageResponseData
				(datas, null, null, pages, viewPage, nextPage, startPage-1, existPrev, existNext);
		
		return respData;
	}
	
	
	// 개설목록 가져오기
	public MyPageResponseData getCreatorMoim(String userId, int page) {
		Sort sort = Sort.by(Direction.ASC, "id");
		
		List<Moim> list = moimRepository.findByManagerId(PageRequest.of(page-1, 10, sort), userId);
		if(list.isEmpty()) {
			
		}
		
		// 화면 페이징처리를 계산한다.
		int total = (int)moimRepository.countByManagerId(userId);
		int totalPage = total/10 + (total % 10 > 0 ? 1: 0);
		int viewPage = 5;
		int endPage = (((page-1)/viewPage)+1) * viewPage;
		int nextPage = 0;
		
		if(totalPage < endPage) {
		    endPage = totalPage;
		}
		int startPage = ((page-1)/viewPage) * viewPage + 1;
		
		int idx = Math.round(startPage / viewPage)+1;
		
		List<PageData> pages = new ArrayList<>();
		for(int i=startPage; i<=5*idx; i++) {
			pages.add(new PageData(String.valueOf(i), page == i));
			if(i == totalPage) {
				nextPage = i+1;
				break;
			}
			nextPage = i+1;
		}
				
		boolean existPrev = page >= 6;
		boolean existNext = true;
		if(endPage >= totalPage)
		{
			existNext = false;
		}
		
		List<MyCreatorMoimData> datas = list.stream().map(MyCreatorMoimData::new).toList();
		MyPageResponseData respData = new MyPageResponseData
				(null, datas, null, pages, viewPage, nextPage, startPage-1, existPrev, existNext);
		
		return respData;
		
	}
}
