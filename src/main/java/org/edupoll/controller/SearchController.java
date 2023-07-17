package org.edupoll.controller;

import org.edupoll.model.dto.search.SearchListResponseData;
import org.edupoll.security.support.Account;
import org.edupoll.service.AvatarService;
import org.edupoll.service.SearchService;
import org.edupoll.service.UserDetailService;
import org.edupoll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/serach")
public class SearchController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	AvatarService avatarService;
	
	@Autowired
	SearchService searchService;
	
	@GetMapping("/moim")
	public String searchMoimViewHandle(String query, 
			@RequestParam(defaultValue = "1")int page, Model model) {
		
		SearchListResponseData datas = searchService.findByQueryMoims(query, page);
		
		model.addAttribute("query", query);
		model.addAttribute("data", datas);
		
		return "main/searchMoim";
	}
	
	@GetMapping("/user")
	public String searchUserViewHandle(String query, 
			@RequestParam(defaultValue = "1")int page, Model model, 
			@AuthenticationPrincipal Account account) {
		
		SearchListResponseData datas = searchService.findByQueryUsers(query, page, account.getUsername());
		
		model.addAttribute("query", query);
		model.addAttribute("data", datas);
		
		return "main/searchUser";
	}
}
