package org.edupoll.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/chat")
public class ChatController {

	
	@GetMapping // 채팅목록 뷰
	public String chatViewHandle() {
		
		return "chat/view";
	}
	
	@PostMapping("/create")
	public String chatCreateHandle(String title) {
		
		
		
		return "";
	}
	
}
