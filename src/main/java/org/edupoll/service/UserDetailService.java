package org.edupoll.service;

import java.util.Optional;

import org.edupoll.model.entity.User;
import org.edupoll.model.entity.UserDetail;
import org.edupoll.repository.UserDetailRepository;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserDetailService {
	
	@Autowired
	UserDetailRepository userDetailRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public boolean modifyUserDetail(UserDetail userDetail, String userId) {
		
		Optional<User> option = userRepository.findById(userId);
		
		if(option.isEmpty()) {
			return false;
		}
		User user = option.get();
		
		if(user.getUserDetailId() != null) {
			userDetail.setIdx(user.getUserDetailId());
			userDetailRepository.save(userDetail);
		}else {
			UserDetail save = userDetailRepository.save(userDetail);
			user.setUserDetailId(save.getIdx());
			userRepository.save(user);
		}
		
		return true;
	}
	
	public UserDetail getUserDetail(String userId) {
		
		User user = userRepository.findById(userId).get();
		if(user.getUserDetailId() == null)
			return null;
		
		return userDetailRepository.findById(user.getUserDetailId()).get();
	}
}
