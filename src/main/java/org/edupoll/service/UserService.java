package org.edupoll.service;

import java.util.Optional;

import org.edupoll.model.dto.LoginData;
import org.edupoll.model.entity.User;
import org.edupoll.model.entity.UserDetail;
import org.edupoll.repository.UserDetailRepository;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailRepository userDetailRepository;
	
	// 회원가입 처리 서비스
	public boolean createNewUser(User user) {
		
		if(userRepository.findById(user.getId()).isEmpty()) {
			userRepository.save(user);
			return true;
		}else {
			return false;
		}
	}
	
	// 로그인 처리를 하기 위해 사용할 서비스
	public boolean isValidUser(LoginData user) {
		Optional<User> optional = userRepository.findById(user.getLoginId());
		if(optional.isPresent()) {
			String savePass = optional.get().getPass();
			return savePass.equals(user.getLoginPass());
		}else {
			return false;
		}
	}
	
	// 유저정보 가져오기
	public User findById(String userId) {
		User user = userRepository.findById(userId).get();
		
		return user;
	}
	
	// 유저 삭제
	public boolean deleteById(String userId) {
		Optional<User> option = userRepository.findById(userId);
		if(option.isEmpty()) {
			return false;
		}
		
		User user = option.get();
		userRepository.delete(user);
		
		if(user.getUserDetailId() != null) {
			UserDetail detail = userDetailRepository.findById(user.getUserDetailId()).get();
			userDetailRepository.delete(detail);
		}
		
		return true;
		
	}
	
	
}
