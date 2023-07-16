package org.edupoll.controller;

import java.util.List;

import org.edupoll.model.dto.etc.CateSeleteWapper;
import org.edupoll.model.dto.moim.MoimPageResponseData;
import org.edupoll.model.entity.User;
import org.edupoll.service.MoimService;
import org.edupoll.service.UserService;
import org.edupoll.util.CateSeleteSupport;
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
	
	@Autowired
	CateSeleteSupport cateSeleteSupport;
	
	@GetMapping("/")
	public String indexHandle(@RequestParam(defaultValue = "1")int page , Model model,
			HttpSession session, String[] cate) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		List<CateSeleteWapper> cates = cateSeleteSupport.cateSelete(cate);
		model.addAttribute("cates", cates);
		
		if(cate != null) {
			String category = "";
			for(String c : cate) {
				category += "&cate="+c;
			}
			model.addAttribute("category", category);
		}

		if(!auth.getName().equals("anonymousUser")) {
			User user = userService.findById(auth.getName());
			if(user.getUserDetail() != null) {
				session.setAttribute("avatarURL", user.getUserDetail().getAvatar().getUrl());
			}
		}
		
		MoimPageResponseData moims = moimService.findByMoimAll(page, cate);
				
		model.addAttribute("moims", moims);
		
		return "main/index";
	}
}
