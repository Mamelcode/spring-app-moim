package org.edupoll.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.edupoll.model.dto.user.UserDetailResponseData;
import org.edupoll.model.entity.Avatar;
import org.edupoll.model.entity.Moim;
import org.edupoll.model.entity.User;
import org.edupoll.model.entity.UserDetail;
import org.edupoll.security.support.Account;
import org.edupoll.service.AvatarService;
import org.edupoll.service.UserDetailService;
import org.edupoll.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import jakarta.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserDetailController {
	
	Logger logger = LoggerFactory.getLogger(UserDetailController.class);
	
	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	UserService userService;
	
	@Autowired
	AvatarService avatarService;
	
	@GetMapping("/detail")
	public String userDetailViewHandle(@AuthenticationPrincipal Account account
			, String error , ModelMap model) throws ParseException {
		
		System.out.println("detail_username ==> "+account.getUsername());
		
		// 유저 디테일 정보 가져오기
		UserDetailResponseData detail = userDetailService.getUserDetail(account.getUsername());
				
		// 유저의 모임리스트 가져오기 / 셋팅하기
		User user = userService.findById(account.getUsername());
		List<Moim> moimList = user.getMoim();
		model.addAttribute("moimList", moimList);
		
		// 아바타 전체 리스트 가져오기 / 셋팅하기
		List<Avatar> avatars = avatarService.getAvatars();
		model.addAttribute("avatars", avatars);
		
		// 로그온 유저의 아바타 정보 가져오기 / 셋팅하기
		Avatar avatar = avatarService.getAvatar(account.getUsername());
		if(detail != null) {
			model.addAttribute("detail", detail);
			if(avatar != null) {
				model.addAttribute("url", avatar.getUrl());
			}
		}
		
		// 디테일 화면으로 넘기기
		return "user/detail";
	}
	
	@PostMapping("/detail")
	public String userDetailModifyHandle(@AuthenticationPrincipal Account account,
			UserDetailResponseData userDetailData, Model model) {
		
		boolean rst = userDetailService.modifyUserDetail(userDetailData, account.getUsername());
		logger.debug("UserdetailHandle .. {} ", rst);
		
		return "redirect:/user/detail";
	}
	
	@GetMapping("/delete")
	public String userDeleteHandle(@AuthenticationPrincipal Account account) {
		
		boolean result = userService.deleteById(account.getUsername());
		
		logger.debug("UserDeleteHandle .. {} ", result);
		
		return "index";
	}
}
