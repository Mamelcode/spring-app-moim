package org.edupoll.controller;

import java.util.ArrayList;
import java.util.List;

import org.edupoll.model.dto.SearchData;
import org.edupoll.model.entity.User;
import org.edupoll.model.entity.UserDetail;
import org.edupoll.service.AvatarService;
import org.edupoll.service.SearchService;
import org.edupoll.service.UserDetailService;
import org.edupoll.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/main")
public class SearchController {
	
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
	public String SearchViewHandle(@RequestParam(defaultValue = "1")int page, String q, Model model) {	
		List<User> users = searchService.findByQuery(q, PageRequest.of(page-1, 5));

		long cnt = searchService.findByQuery(q).size();
		System.out.println("cnt => "+ cnt);
		List<String> pages = new ArrayList<>();
		for(int i=1; i<=cnt/5 + (cnt % 5 > 0 ? 1 : 0); i++) {
			pages.add(String.valueOf(i));
		}
		model.addAttribute("pages", pages);	
		model.addAttribute("q", q);
		
		List<UserDetail> userDetails = searchService.UserDetailList(users);
		
		List<SearchData> searchDatas = searchService.UserAndDetailList(users, userDetails);
				
		model.addAttribute("searchDatas", searchDatas);
		
		return "main/search";
	}
	
	
	
}
