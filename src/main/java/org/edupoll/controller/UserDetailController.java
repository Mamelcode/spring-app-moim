package org.edupoll.controller;

import java.text.ParseException;

import org.edupoll.model.dto.user.UserDetailReqeustData;
import org.edupoll.model.dto.user.UserDetailResponseData;
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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/mypage")
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
		UserDetailResponseData detail = userDetailService.getUserDetail(account.getUsername());
		
		model.addAttribute("detail", detail);
		
		// 디테일 화면으로 넘기기
		return "mypage/detail";
	}
	
	@PostMapping("/detail")
	public String userDetailModifyHandle(@AuthenticationPrincipal Account account,
			UserDetailReqeustData data, Model model) {
		
		boolean rst = userDetailService.modifyUserDetail(data, account.getUsername());
		logger.debug("UserdetailHandle .. {} ", rst);
		
		return "redirect:/mypage/detail";
	}
	
	@GetMapping("/delete")
	public String userDeleteHandle(@AuthenticationPrincipal Account account) {
		
		boolean result = userService.deleteById(account.getUsername());
		
		logger.debug("UserDeleteHandle .. {} ", result);
		
		return "index";
	}
}
