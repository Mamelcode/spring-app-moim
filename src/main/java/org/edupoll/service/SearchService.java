package org.edupoll.service;

import java.awt.print.Pageable;
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
	
	public List<User> findByQuery(String q, PageRequest pageRequest) {
		List<User> list = userRepository.findByIdContainingOrNickContaining(q, q, pageRequest);
		return list;
	}
	
	public List<UserDetail> UserDetailList(List<User> user) {
		
		List<UserDetail> userDetails = new ArrayList<>();
		
		for(User u : user) {
			if(u.getUserDetailId() != null) {
				userDetails.add(userDetailRepository.findById(u.getUserDetailId()).get());
			}
		}
		return userDetails;
	}
	
	public List<SearchData> UserAndDetailList(List<User> users, List<UserDetail> details) {
		List<SearchData> searchDatas = new ArrayList<>();
		
		for(User u : users) {
			if(u.getUserDetailId() == null) {
				SearchData sd = new SearchData();
				sd.setId(u.getId());
				sd.setNick(u.getNick());
				sd.setJoinDate(u.getJoinDate());
				searchDatas.add(sd);
			}
			for(UserDetail d : details) {
				if(u.getUserDetailId() != null) {
					SearchData sd = new SearchData();
					if(u.getUserDetailId().equals(d.getIdx())) {
						if(d.getAvatarId() != null) {
							sd.setAvatarURL(avatarRepository.findById(d.getAvatarId()).get().getUrl());
						}
						sd.setId(u.getId());
						sd.setNick(u.getNick());
						sd.setDescription(d.getDescription());
						sd.setAddress(d.getAddress());
						sd.setBirthday(d.getBirthday());
						sd.setJoinDate(u.getJoinDate());
						
						searchDatas.add(sd);
						break;
					}
				}
			}
		}

		return searchDatas;
	}
}
