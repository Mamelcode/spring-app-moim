package org.edupoll.controller;

import org.edupoll.model.dto.LoginData;
import org.edupoll.model.entity.User;
import org.edupoll.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.servlet.http.HttpSession;

@Controller
@RequestMapping("/user")
public class UserController {
	
	Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	UserService userService;
	
	@GetMapping("/join")
	public String joinViewHandle() {
		
		return "user/join";
	}
	
	@PostMapping("/join")
	public String joinTaskHandle(User user, Model model) {
		boolean result = userService.createNewUser(user);
		logger.debug("userJoinHandle : {} ", result);
		if(result) {
			return "redirect:/user/login";
		}else {
			model.addAttribute("error", true);
			return "user/join";
		}
	}
	
	@GetMapping("/login")
	public String loginViewHandle() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String loginTaskHandle(LoginData data, Model model, HttpSession session) {
		boolean result = userService.isValidUser(data);
		logger.debug("userLoginHandle : {} ", result);
		if(result) {
			session.setAttribute("logonId", data.getLoginId());
			return "redirect:/main";
		}
		
		model.addAttribute("error", true);
		return "user/login";
	}
	
	@GetMapping("/logout")
	public String userLogOutHandle(HttpSession session) {
		session.removeAttribute("logonId");
		
		String logonId = (String)session.getAttribute("logonId");
		logger.debug("userLogOutteHandle : {} ", logonId);
		
		return "index";
	}
	
}
