package org.edupoll.repository;

import java.util.List;

import org.edupoll.model.entity.Attendance;
import org.edupoll.model.entity.User;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AttendanceRepository extends JpaRepository<Attendance, Integer> {
	boolean existsByUserIdIsAndMoimIdIs(String userId, String moimId);
	
	List<Attendance> findByMoimIdIs(String moimId);
	
	void removeByUserIdIsAndMoimIdIs(String userId, String moimId);
	
	List<Attendance> findByUserIdIs(PageRequest page, String userId);
	
	long countByUserId(String userId);
}
