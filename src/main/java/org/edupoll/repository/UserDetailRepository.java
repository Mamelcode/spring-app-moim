package org.edupoll.repository;

import org.edupoll.model.entity.UserDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface UserDetailRepository extends JpaRepository<UserDetail, Integer>{
	
}
