package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import com.example.entity.UserDataEntity;
import com.example.entity.UserLoginDetailsEntity;

public interface UserLoginJpaRepository extends  JpaRepository<UserLoginDetailsEntity, Integer>{

	
	
	@Query(value="select * from user_login where id=:user_id",nativeQuery=true)
	UserLoginDetailsEntity findbyUserId(@Param("user_id")long user_id);

//	UserDataEntity findByUserId(long user_id);

}
