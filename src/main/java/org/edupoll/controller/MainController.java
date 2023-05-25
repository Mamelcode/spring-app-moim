package org.edupoll.controller;

import java.util.List;

import org.edupoll.model.dto.SearchData;
import org.edupoll.model.entity.User;
import org.edupoll.model.entity.UserDetail;
import org.edupoll.service.AvatarService;
import org.edupoll.service.SearchService;
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
	
	@Autowired
	SearchService searchService;
	
	@GetMapping
	public String SearchViewHandle() {
		
		return "main/search";
	}
	
	@GetMapping("/search")
	public String SearchViewHandle(String q, Model model) {	
		List<User> users = searchService.findByQuery(q);
		List<UserDetail> userDetails = searchService.UserDetailList(users);
		
		List<SearchData> searchDatas = searchService.UserAndDetailList(users, userDetails);
				
		model.addAttribute("searchDatas", searchDatas);
		
		return "main/search";
	}
	
	
	
}
