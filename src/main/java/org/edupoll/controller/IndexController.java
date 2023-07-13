package org.edupoll.controller;

import java.util.ArrayList;
import java.util.List;

import org.edupoll.model.dto.moim.MoimListResponseData;
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
		
		List<MoimListResponseData> moims = moimService.findByMoimAll(page);
		
		// 페이징처리
		int total = (int)moimService.countMoim();
		int totalPage = total/12 + (total % 12 > 0 ? 1: 0);
		int viewPage = 5;
		int endPage = (((page-1)/viewPage)+1) * viewPage;
		if(totalPage < endPage) {
		    endPage = totalPage;
		}
		int startPage = ((page-1)/viewPage) * viewPage + 1;
		
		int idx = Math.round(startPage / viewPage)+1;

		List<String> pages = new ArrayList<>();
		for(int i=startPage; i<=5*idx; i++) {
			pages.add(String.valueOf(i));
			if(i == totalPage) {
				model.addAttribute("nextPage", i+1);
				break;
			}
			model.addAttribute("nextPage", i+1);
		}
		
		boolean existPrev = page >= 6;
		boolean existNext = true;
		if(endPage >= totalPage)
		{
			existNext = false;
		}
		model.addAttribute("prev", existPrev);
		model.addAttribute("next", existNext);
		model.addAttribute("prevPage", startPage-1);		
		model.addAttribute("pages", pages);	
		// 페이징처리
				
		model.addAttribute("moims", moims);
		
		return "main/index";
	}
}
