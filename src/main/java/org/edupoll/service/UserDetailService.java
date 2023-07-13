package org.edupoll.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.edupoll.model.dto.user.AvatarResponseData;
import org.edupoll.model.dto.user.UserDetailReqeustData;
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
	
	// 유저 디테일 정보 수정
	public boolean modifyUserDetail(UserDetailReqeustData data, String userId) {
		
		// 유저를 찾는다.
		Optional<User> option = userRepository.findById(userId);
		
		// 유저가 비어있는지 확인한다.
		if(option.isEmpty()) {
			return false;
		}
		
		// 유저가 있으면 유저객체를 만든다.
		User user = option.get();
		
		
		// 세이브할 유저 디테일 객체를 만든다.
		UserDetail detail = new UserDetail(data);
		
		// 아바타를 선택했는지 확인한다.
		if(data.getAvatarId() != null)
			detail.setAvatar(avatarRepository.findById(data.getAvatarId()).get());
		
		// 새로 저장하는건지 기존껄 수정하는건지 확인한다.
		if(user.getUserDetail() != null) {			
			data.setIdx(user.getUserDetail().getIdx());
		}
		
		// 세이브한다.
		user.setUserDetail(detail);
		userDetailRepository.save(detail);
		
		return true;
	}
	
	
	// 유저 디테일 정보 가져오기
	public UserDetailResponseData getUserDetail(String userId) {
		UserDetail detail = userRepository.findById(userId).get().getUserDetail();
		
		// 아바타 정보 리스트를 가져온다
		List<Avatar> avatars = avatarRepository.findAll();

		if(detail != null) {			
			// 아바타 응답 dto를 담을 리스트를 만든다.
			List<AvatarResponseData> avatarsData = new ArrayList<>();
			
			// 반복문을 돌면서 나의 아바타인지 확인하여 참 / 거짓을 확인한다.
			for(Avatar a : avatars) {
				AvatarResponseData avatarData = new AvatarResponseData(a);
				if(detail.getAvatar().getId().equals(a.getId())) {
					avatarData.setMyAvatar(true);
				}
				avatarsData.add(avatarData);
			}
			
			// 유저 디테일 응답 dto에 유저디테일과 아바타리스트를 담아서 리턴한다.
			UserDetailResponseData detailData = new UserDetailResponseData(detail, avatarsData);
			return detailData;
		}else {
			List<AvatarResponseData> avatarsData = new ArrayList<>();
			for(Avatar a : avatars) {
				avatarsData.add(new AvatarResponseData(a));
			}
			return new UserDetailResponseData(avatarsData);
		}
	}
}
