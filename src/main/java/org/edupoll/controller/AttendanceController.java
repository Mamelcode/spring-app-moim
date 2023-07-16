package org.edupoll.controller;

import org.edupoll.security.support.Account;
import org.edupoll.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/moim")
public class AttendanceController {

	@Autowired
	AttendanceService attendanceService;
	
	@GetMapping("/attendance")
	public String attendanceHandle(@AuthenticationPrincipal Account account, String moimId, Model model) {
		
		int result = attendanceService.createAttendance(moimId, account.getUsername());
		
		// 0:성공 1:참가중 2:정원초과
		if(result == 0) {
			return "redirect:/moim/view?moimId="+moimId;
		}else if(result == 1) {
			return "redirect:/moim/view?moimId="+moimId+"&error=1";
		}else {
			return "redirect:/moim/view?moimId="+moimId+"&error=2";
		}
	}
	
	@GetMapping("/cancle")
	public String cancleHandle(@AuthenticationPrincipal Account account, String moimId) {
		
		System.out.println("참가취소 : "+moimId+"/"+account.getUsername());
		
		boolean result = attendanceService.deleteAttendance(moimId, account.getUsername());
		
		return "redirect:/moim/view?moimId="+moimId;
	}
}
