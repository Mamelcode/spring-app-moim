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
	
	long countByCate(String cate);
	
	@Query("select m from Moim m where m.cate in :cate")
	List<Moim> findByCates(PageRequest page, @Param("cate") String[] cate);
	
	List<Moim> findByManagerId(PageRequest page, String managerId);
	
	long countByManagerId(String managerId);
}
