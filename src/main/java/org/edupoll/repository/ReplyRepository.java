package org.edupoll.repository;

import java.util.List;

import org.edupoll.model.entity.Reply;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReplyRepository extends JpaRepository<Reply, Integer>{
	List<Reply> findByMoimId(String moimId, PageRequest pageRequest);
	List<Reply> findByMoimId(String moimId);
	
	long countByMoimId(String moimId);
	
	List<Reply> findByUserId(PageRequest page, String userId);
	long countByUserId(String userId);
}
