package org.edupoll.service;

import java.util.Optional;

import org.edupoll.model.dto.request.LoginRequestData;
import org.edupoll.model.entity.User;
import org.edupoll.model.entity.UserDetail;
import org.edupoll.repository.UserDetailRepository;
import org.edupoll.repository.UserRepository;
import org.edupoll.security.support.AccountManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	UserDetailRepository userDetailRepository;
	
	@Autowired
	AccountManager accountManager;
	
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
	public boolean isValidUser(LoginRequestData user) {
		Optional<User> optional = userRepository.findById(user.getLoginId());
		if(optional.isPresent()) {
			String savePass = optional.get().getPass();
			return savePass.equals(user.getLoginPass());
		}else {
			return false;
		}
	}
	
	// 특정 유저정보 가져오기
	public User findById(String userId) {
		return userRepository.findById(userId).orElse(null);
	}
	
	// 유저 삭제
	@Transactional
	public boolean deleteById(String userId) {
		Optional<User> option = userRepository.findById(userId);
		if(option.isEmpty()) {
			return false;
		}
		
		User user = option.get();
		userRepository.delete(user);
		
		if(user.getUserDetail() != null) {
			userDetailRepository.delete(user.getUserDetail());
		}
		
		return true;
		
	}
}
