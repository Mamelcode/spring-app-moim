package org.edupoll.service;
import java.util.ArrayList;
import java.util.List;

import org.edupoll.model.dto.etc.PageData;
import org.edupoll.model.dto.search.SearchListResponseData;
import org.edupoll.model.dto.search.SearchMoimResponseData;
import org.edupoll.model.dto.search.SearchUserResponseData;
import org.edupoll.model.entity.Moim;
import org.edupoll.model.entity.User;
import org.edupoll.repository.FollowRepository;
import org.edupoll.repository.MoimRepository;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	FollowRepository followRepository;
	
	@Autowired
	MoimRepository moimRepository;
				
	
	//모임 검색 결과
	public SearchListResponseData findByQueryMoims(String q, int page) {
		Sort sort = Sort.by(Direction.DESC, "targetDate");
		List<Moim> list = moimRepository.findByTitleContaining(PageRequest.of(page-1, 12, sort), q);
		
		// 유저 검색 결과 카운트
		Integer userCnt = userRepository.countByIdContainingOrNickContaining(q, q);
		// 모임 검색 결과 카운트
		Integer moimCnt = moimRepository.countByTitleContaining(q);

		// 페이징 처리 구간
		int total = (int)moimCnt;
		int totalPage = total/12 + (total % 12 > 0 ? 1: 0);
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
			if(i >= totalPage) {
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
		// ===========
		
		List<SearchMoimResponseData> datas = list.stream().map(SearchMoimResponseData::new).toList();
		
		return new SearchListResponseData
				(datas, null, moimCnt, userCnt, pages, viewPage, nextPage, startPage-1, existPrev, existNext);
	}
	
	// 유저 검색 결과
	public SearchListResponseData findByQueryUsers(String q, int page, String userId) {
		Sort sort = Sort.by(Direction.DESC, "joinDate");
		
		List<User> list = userRepository.findByIdContainingOrNickContaining(q, q, PageRequest.of(page-1, 20, sort));
		
		// 유저 검색 결과 카운트
		Integer userCnt = userRepository.countByIdContainingOrNickContaining(q, q);
		// 모임 검색 결과 카운트
		Integer moimCnt = moimRepository.countByTitleContaining(q);
		
		// 페이징 처리 구간
		int total = (int)userCnt;
		int totalPage = total/20 + (total % 20 > 0 ? 1: 0);
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
			if(i >= totalPage) {
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
		// ===========
		
		List<SearchUserResponseData> datas = list.stream().map(SearchUserResponseData::new).toList();
		datas.forEach(t -> {
			if(followRepository.existsByOwnerIdIsAndTargetIdIs(userId, t.getUserId())) {
				t.setFollowed(true);
			}
			if(userId.equals(t.getUserId())) {
				t.setMe(true);
			}
		});
		
		return new SearchListResponseData
				(null, datas, moimCnt, userCnt, pages, viewPage, nextPage, startPage-1, existPrev, existNext);
	}
}
