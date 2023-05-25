package org.edupoll.controller;

import org.edupoll.service.AvatarService;
import org.edupoll.service.UserDetailService;
import org.edupoll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	AvatarService avatarService;
	
	@GetMapping
	public String SearchViewHandle() {
		
		return "main/search";
	}
	
	@GetMapping("/search")
	public String SearchViewHandle(String q, Model model) {
		
		System.out.println("Search... "+ q);
		
		return "main/search";
	}
	
	
	
}
