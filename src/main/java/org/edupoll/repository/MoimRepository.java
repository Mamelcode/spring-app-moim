package org.edupoll.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.edupoll.model.entity.Moim;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MoimRepository extends JpaRepository<Moim, String> {
	List<Moim> findByCate(PageRequest page, String cate);
	
	// 모임날짜가 현재시간보다 이전이면 가져오지 않는다.
	@Query("select m from Moim m where m.targetDate > :nowDate")
	List<Moim> findByMoims(PageRequest page, @Param("nowDate") LocalDateTime nowDate);
	
	@Query("select count(m) from Moim m where m.targetDate > :nowDate")
	long countByMoims(@Param("nowDate") LocalDateTime nowDate);
	
	// 카테고리 정렬 관련
	@Query("select count(m) from Moim m where m.cate = :cate and m.targetDate > :nowDate")
	long countByCate(String cate, LocalDateTime nowDate);
	
	@Query("select m from Moim m where m.cate in :cate and m.targetDate > :nowDate")
	List<Moim> findByCates(PageRequest page, @Param("cate") String[] cate, @Param("nowDate") LocalDateTime nowDate);
	
	// 마이페이지 관련
	List<Moim> findByManagerId(PageRequest page, String managerId);
	
	long countByManagerId(String managerId);
	
	// 서치관련
	List<Moim> findByTitleContaining(PageRequest page, String title);
	
	Integer countByTitleContaining(String title);
}
