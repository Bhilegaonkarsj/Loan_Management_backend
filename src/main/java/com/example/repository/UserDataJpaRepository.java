package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.UserDataEntity;

public interface UserDataJpaRepository extends  JpaRepository<UserDataEntity, Integer>{

	
	@Query(value="select * from user_data where id=:user_id",nativeQuery=true)
	UserDataEntity findByUserId(@Param("user_id")Integer user_id);

	
	@Query(value="select * from user_data where user_name=:user_name and mobile_number=:mobileNo",nativeQuery=true)
	UserDataEntity findbyUserIdAndMobileNo(@Param("user_name")String user_name,@Param("mobileNo") String mobileNo);

}
