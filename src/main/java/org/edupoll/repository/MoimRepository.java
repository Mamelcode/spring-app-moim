package org.edupoll.repository;

import java.util.List;

import org.edupoll.model.entity.Moim;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MoimRepository extends JpaRepository<Moim, String> {
	List<Moim> findByCate(PageRequest page, String cate);
	
	// 카테고리 정렬 관련
	long countByCate(String cate);	
	
	@Query("select m from Moim m where m.cate in :cate")
	List<Moim> findByCates(PageRequest page, @Param("cate") String[] cate);
	
	// 마이페이지 관련
	List<Moim> findByManagerId(PageRequest page, String managerId);
	
	long countByManagerId(String managerId);
	
	// 서치관련
	List<Moim> findByTitleContaining(PageRequest page, String title);
	
	Integer countByTitleContaining(String title);
}
