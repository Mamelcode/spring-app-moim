package org.edupoll.service;
import java.util.ArrayList;
import java.util.List;

import org.edupoll.model.dto.SearchData;
import org.edupoll.model.entity.User;
import org.edupoll.model.entity.UserDetail;
import org.edupoll.repository.AvatarRepository;
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
	
	public List<User> findByQuery(String q) {
		List<User> list = userRepository.findByIdContainingOrNickContaining(q, q);
		return list;
	}
			
	public List<SearchData> findByQuery2(String q, PageRequest pageRequest) {
		List<User> list = userRepository.findByIdContainingOrNickContaining(q, q, pageRequest);
		List<SearchData> searchs = new ArrayList<>();
		
		list.forEach(o -> {
			searchs.add(new SearchData(o));
		});
		
		return searchs;
	}
}
