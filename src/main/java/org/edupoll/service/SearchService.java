package org.edupoll.service;
import java.util.ArrayList;
import java.util.List;

import org.edupoll.model.dto.search.SearchResponseData;
import org.edupoll.model.entity.User;
import org.edupoll.model.entity.UserDetail;
import org.edupoll.repository.AvatarRepository;
import org.edupoll.repository.FollowRepository;
import org.edupoll.repository.UserDetailRepository;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class SearchService {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailRepository userDetailRepository;
	
	@Autowired
	AvatarRepository avatarRepository;
	
	@Autowired
	FollowRepository followRepository;
	
	public List<User> findByQuery(String q) {
		List<User> list = userRepository.findByIdContainingOrNickContaining(q, q);
		return list;
	}
			
	public List<SearchResponseData> findByQuery2(String logonId, String q, PageRequest pageRequest) {
		List<User> list = userRepository.findByIdContainingOrNickContaining(q, q, pageRequest);
		List<SearchResponseData> searchs = new ArrayList<>();
		
		for(User u : list) {
			boolean flag = followRepository.existsByOwnerIdIsAndTargetIdIs(logonId, u.getId());
			searchs.add(new SearchResponseData(u, flag));
		}
				
		return searchs;
	}
}
