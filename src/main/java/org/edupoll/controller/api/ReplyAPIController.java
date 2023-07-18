package org.edupoll.controller.api;

import org.edupoll.model.dto.reply.ReplyAPIResponseData;
import org.edupoll.service.ReplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ReplyAPIController {

	@Autowired
	ReplyService replyService;
	
	@DeleteMapping("/reply")
	public ResponseEntity<?> deleteReplyHandle(Integer replyId) {
		
		ReplyAPIResponseData result = replyService.deleteReply(replyId);
		
		return ResponseEntity.ok(result);
	}
	
}
