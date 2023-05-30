package org.edupoll.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

import org.edupoll.model.dto.UserDetailData;
import org.edupoll.model.entity.Avatar;
import org.edupoll.model.entity.UserDetail;
import org.edupoll.service.AvatarService;
import org.edupoll.service.UserDetailService;
import org.edupoll.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
	public String userDetailViewHandle(@SessionAttribute String logonId
			, String error , ModelMap model) throws ParseException {
		
		UserDetailData detail = userDetailService.getUserDetail(logonId);
		List<Avatar> avatars = avatarService.getAvatars();
		Avatar avatar = avatarService.getAvatar(logonId);
		model.addAttribute("avatars", avatars);
		
		if(detail != null) {
			model.addAttribute("detail", detail);
			if(avatar != null) {
				model.addAttribute("url", avatar.getUrl());
			}
		}
			
		return "user/detail";
	}
	
	@PostMapping("/detail")
	public String userDetailModifyHandle(@SessionAttribute String logonId,
			UserDetailData userDetailData, Model model) {
				
		boolean rst = userDetailService.modifyUserDetail(userDetailData, logonId);
		logger.debug("UserdetailHandle .. {} ", rst);
		
		return "redirect:/user/detail";
	}
	
	@GetMapping("/delete")
	public String userDeleteHandle(@SessionAttribute String logonId) {
		
		boolean result = userService.deleteById(logonId);
		
		logger.debug("UserDeleteHandle .. {} ", result);
		
		return "index";
	}
}
