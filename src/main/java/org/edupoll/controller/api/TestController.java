package org.edupoll.controller.api;

import org.edupoll.model.dto.response.TestResponseData;
import org.edupoll.model.entity.User;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@Controller
@RequestMapping("/api")
public class TestController {

	@Autowired
	ObjectMapper objectMapper;
	
	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/test-a")
	@ResponseBody
	public String testAHandle() throws JsonProcessingException {
		
		String[] ar = new String[] {"나루토", "사스케", "카카시"};
		
		String jsonStr = objectMapper.writeValueAsString(ar);
		
		return jsonStr;
	}
	
	@GetMapping("/test-b")
	@ResponseBody
	public String[] testBHandle() {
		String[] ar = new String[] {"나루토", "사스케", "카카시"};
		
		return ar;
	}
	
	@GetMapping("/test-c")
	@ResponseBody
	public TestResponseData testCHandle() {
		TestResponseData data = 
				new TestResponseData(2, "정상처리", new String[]{"나루토", "사스케", "카카시"});
		
		return data;
	}
	
	@GetMapping("/test-d")
	@ResponseBody
	public User testDHandle() {
		User user = userRepository.findById("anwnlro").get();
		
		return user;
	}
}
