package org.edupoll.controller;

import org.edupoll.model.dto.moim.MoimPageResponseData;
import org.edupoll.model.entity.User;
import org.edupoll.service.MoimService;
import org.edupoll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class IndexController {

	@Autowired
	UserService userService;
	
	@Autowired
	MoimService moimService;
	
	@GetMapping("/")
	public String indexHandle(@RequestParam(defaultValue = "1")int page , Model model,
			HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
				
		if(!auth.getName().equals("anonymousUser")) {
			User user = userService.findById(auth.getName());
			if(user.getUserDetail() != null) {
				session.setAttribute("avatarURL", user.getUserDetail().getAvatar().getUrl());
			}
		}
		
		MoimPageResponseData moims = moimService.findByMoimAll(page);
				
		model.addAttribute("moims", moims);
		
		return "main/index";
	}
}
