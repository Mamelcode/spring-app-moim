package org.edupoll.service;

import java.util.List;

import org.edupoll.model.dto.reply.ReplyCreateRequestData;
import org.edupoll.model.entity.Moim;
import org.edupoll.model.entity.Reply;
import org.edupoll.model.entity.User;
import org.edupoll.repository.MoimRepository;
import org.edupoll.repository.ReplyRepository;
import org.edupoll.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ReplyService {
	
	@Autowired
	ReplyRepository replyRepository;
	
	@Autowired
	MoimRepository moimRepository;
	
	@Autowired
	UserRepository userRepository;
	
	//댓글쓰기
	@Transactional
	public boolean crateReply(ReplyCreateRequestData data, String userId) {
		
		Moim moim = moimRepository.findById(data.getMoimId()).orElse(null);
		User user = userRepository.findById(userId).orElse(null);
		
		Reply reply = new Reply(data.getText(), moim, user);
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
