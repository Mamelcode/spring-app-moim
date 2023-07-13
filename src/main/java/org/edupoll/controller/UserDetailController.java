package org.edupoll.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.edupoll.model.dto.user.UserDetailReqeustData;
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
			, String error , Model model) throws ParseException {
		System.out.println("로그인 닉네임 : "+ account.getNick() + "/" + account.getUsername());
		UserDetailResponseData detail = userDetailService.getUserDetail(account.getUsername());
		
		model.addAttribute("detail", detail);
		
		// 디테일 화면으로 넘기기
		return "user/detail";
	}
	
	@PostMapping("/detail")
	public String userDetailModifyHandle(@AuthenticationPrincipal Account account,
			UserDetailReqeustData data, Model model) {
		
		boolean rst = userDetailService.modifyUserDetail(data, account.getUsername());
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
