package org.edupoll.controller;

import java.util.ArrayList;
import java.util.List;

import org.edupoll.model.dto.moim.MoimListResponseData;
import org.edupoll.model.entity.Moim;
import org.edupoll.model.entity.Reply;
import org.edupoll.model.entity.User;
import org.edupoll.security.support.Account;
import org.edupoll.service.AttendanceService;
import org.edupoll.service.MoimService;
import org.edupoll.service.ReplyService;
import org.edupoll.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/moim")
public class MoimController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	MoimService moimService;
	
	@Autowired
	ReplyService replyService;
	
	@Autowired
	AttendanceService attendanceService;
	
	@Autowired
	UserService userService;
	
	// 모임 만들기 뷰
	@GetMapping("/create")
	public String moimCreateViewHandle(Model model, HttpSession session) {
		String[] cates = new String[] {"취미","학습","봉사","건강","비지니스","문화","스포츠"};
		String[] persons = new String[] {"2","3","4","5","6","7","8","9","10"};
		
		model.addAttribute("cates", cates);
		model.addAttribute("persons", persons);
				
		return "main/moimCreate";
	}
	
	// 모임 만들기 처리
	@PostMapping("/create")
	public String moimCreateHandle(@AuthenticationPrincipal Account account , Moim moim) {
		
		logger.debug("moim crate ==> {} ", moim);
		boolean result = moimService.createMoim(moim, account.getUsername());
		
		return "redirect:/";
	}
	
	// 모임 디테일 뷰
	@GetMapping("/view")
	public String moimViewHandle(@RequestParam(defaultValue = "1")int page, String moimId,@AuthenticationPrincipal Account account, Model model) {
		Moim moim = moimService.findByMoim(moimId);
		logger.debug("View moim Handle ==> {}", moim);
		
		List<Reply> replys = replyService.findByReplys(moimId, page);
		logger.debug("View replys Handle ==> {}", replys);
		
		long cnt = replyService.findByReplysCount(moimId);
		List<String> pages = new ArrayList<>();
		for(int i=1; i<=cnt/10 + (cnt % 10 > 0 ? 1 : 0); i++) {
			pages.add(String.valueOf(i));
			if(i == 10) {
				break;
			}
		}
		model.addAttribute("pages", pages);	
		model.addAttribute("replys", replys);
		model.addAttribute("moim", moim);
		model.addAttribute("isJoined", attendanceService.isJoined(account.getUsername(), moimId));
		
		return "main/moimView";
	}
	
	// 모임 댓글 처리
	@PostMapping("/reply-create")
	public String replyCreateHandle(Reply reply) {		
		replyService.crateReply(reply);
		
		return "redirect:/moim/view?moimId="+reply.getMoim().getId();
	}
}
