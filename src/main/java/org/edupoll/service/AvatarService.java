package org.edupoll.service;

import java.util.List;

import org.edupoll.model.entity.Avatar;
import org.edupoll.model.entity.User;
import org.edupoll.model.entity.UserDetail;
import org.edupoll.repository.AvatarRepository;
import org.edupoll.repository.UserDetailRepository;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AvatarService {

	@Autowired
	AvatarRepository avatarRepository;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailRepository userDetailRepository;
	
	public List<Avatar> getAvatars() {
		return avatarRepository.findAll();
	}
	
	public Avatar getAvatar(String logonId) {
		User user = userRepository.findById(logonId).get();
		
		if(user.getUserDetailId() == null) {
			return null;
		}
		UserDetail userDetail = userDetailRepository.findById(user.getUserDetailId()).get();
		return avatarRepository.findById(userDetail.getAvatarId()).get();
	}
	
}
