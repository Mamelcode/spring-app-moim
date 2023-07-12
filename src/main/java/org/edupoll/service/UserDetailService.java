package org.edupoll.service;

import java.util.Optional;

import org.edupoll.model.dto.user.UserDetailResponseData;
import org.edupoll.model.entity.Avatar;
import org.edupoll.model.entity.User;
import org.edupoll.model.entity.UserDetail;
import org.edupoll.repository.AvatarRepository;
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
	
	@Autowired
	AvatarRepository avatarRepository;
	
	public boolean modifyUserDetail(UserDetailResponseData userDetailData, String userId) {
		
		Optional<User> option = userRepository.findById(userId);
		
		if(option.isEmpty()) {
			return false;
		}
		User user = option.get();
		
		UserDetail userDetail = new UserDetail();		
		userDetail.setAddress(userDetailData.getAddress());	
		userDetail.setBirthday(userDetailData.getBirthday());
		userDetail.setDescription(userDetailData.getDescription());
		
		if(userDetailData.getAvatarId() != null)
			userDetail.setAvatar(avatarRepository.findById(userDetailData.getAvatarId()).get());
		
		if(user.getUserDetail() != null) {			
			userDetail.setIdx(user.getUserDetail().getIdx());
		}
		
		user.setUserDetail(userDetail);
		UserDetail save = userDetailRepository.save(userDetail);
		
		return true;
	}
	
	public UserDetailResponseData getUserDetail(String userId) {
		UserDetail detail = userRepository.findById(userId).get().getUserDetail();

		UserDetailResponseData detailData = new UserDetailResponseData();
		
		if(detail != null) {
			detailData.setAddress(detail.getAddress());
			detailData.setBirthday(detail.getBirthday());
			detailData.setDescription(detail.getDescription());
		}
		
		return detailData;
	}
}
