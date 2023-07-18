package org.edupoll.controller;

import org.edupoll.model.dto.mypage.MyPageResponseData;
import org.edupoll.security.support.Account;
import org.edupoll.service.MyPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/mypage")
public class MyPageController {

	@Autowired
	MyPageService myPageService;
	
	// 참여목록 뷰
	@GetMapping("/attendance")
	public String attendanceViewHandle(@RequestParam(defaultValue = "1") int page, 
			@AuthenticationPrincipal Account account, Model model) {
		
		MyPageResponseData datas = myPageService.getAttendanceMoims(account.getUsername(), page);
		
		model.addAttribute("data", datas);
		
		return "mypage/myAttendanceMoim";
	}
	
	// 개설목록 뷰
	@GetMapping("/creator")
	public String creatorViewHandle(@RequestParam(defaultValue = "1") int page, 
			@AuthenticationPrincipal Account account, Model model) {
		
		MyPageResponseData datas =  myPageService.getCreatorMoim(account.getUsername(), page);
		
		model.addAttribute("data", datas);
		
		return "mypage/myCreatorMoim";
	}
	
	// 댓글목록 뷰
	@GetMapping("/reply")
	public String replyViewHandle(@RequestParam(defaultValue = "1") int page, 
			@AuthenticationPrincipal Account account, Model model) {
		
		MyPageResponseData datas = myPageService.getMyReply(account.getUsername(), page);
		
		model.addAttribute("data", datas);
		
		return "mypage/myReply";
	}
	
	// 팔로우 목록 뷰
	@GetMapping("/follow")
	public String followViewHandle(@RequestParam(defaultValue = "1") int page, 
			@AuthenticationPrincipal Account account, Model model) {
		
		MyPageResponseData datas = myPageService.getMyFollow(account.getUsername(), page);
				
		model.addAttribute("data", datas);
		
		return "mypage/myFollow";
	}
	
	
}
