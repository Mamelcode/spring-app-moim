package org.edupoll.service;

import java.util.List;

import org.edupoll.model.entity.Reply;
import org.edupoll.repository.ReplyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

@Service
public class ReplyService {
	
	@Autowired
	ReplyRepository replyRepository;
	
	//댓글쓰기
	public boolean crateReply(Reply reply) {		
		replyRepository.save(reply);
		return true;
	}
	
	public List<Reply> findByReplys(String moimId, int page) {
		Sort sort = Sort.by(Direction.ASC ,"id");
		List<Reply> list = 
				replyRepository.findByMoimId(moimId, PageRequest.of(page-1, 10, sort));
		
		return list;
	}
	
	public long findByReplysCount(String moimId) {
		List<Reply> list = 
				replyRepository.findByMoimId(moimId);
		
		return list.size();
	}
	
}
