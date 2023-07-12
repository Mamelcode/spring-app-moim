package org.edupoll.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.edupoll.model.dto.response.MoimListResponseData;
import org.edupoll.model.entity.Moim;
import org.edupoll.model.entity.Reply;
import org.edupoll.security.support.Account;
import org.edupoll.service.AttendanceService;
import org.edupoll.service.MoimService;
import org.edupoll.service.ReplyService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttribute;

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
	
	// 모임 만들기 뷰
	@GetMapping("/create")
	public String moimCreateViewHandle(Model model) {
		
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
		
		return "redirect:/moim/list";
	}
	
	// 모임 리스트
	@GetMapping("/list")
	public String moimListHandle(@RequestParam(defaultValue = "1")int page , Model model,
			HttpSession session) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		session.setAttribute("logonId", auth.getName());
		
		System.out.println("인증유저 ==> "+ auth.getName());
		List<Moim> moims = moimService.findByMoimAll(page);
		
		SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
		
		List<MoimListResponseData> list = new ArrayList<>();
		
		for(Moim m : moims) {
			MoimListResponseData data = new MoimListResponseData();
			data.setId(m.getId());
			data.setCate(m.getCate());
			data.setCurrentPerson(m.getCurrentPerson());
			data.setDescription(m.getDescription());
			data.setDuration(m.getDuration());
			data.setFormatDate(sd.format(m.getTargetDate()));
			data.setTitle(m.getTitle());
			data.setMaxPerson(m.getMaxPerson());
			
			list.add(data);
		}
		
		
		// 페이징처리
		int total = (int)moimService.countMoim();
		int totalPage = total/9 + (total % 9 > 0 ? 1: 0);
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
				
		model.addAttribute("moims", list);
		
		return "main/moimList";
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
