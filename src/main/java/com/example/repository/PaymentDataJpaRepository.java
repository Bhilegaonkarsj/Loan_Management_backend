package com.example.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.PaymentDataEntity;

public interface PaymentDataJpaRepository extends  JpaRepository<PaymentDataEntity, Integer>{

	
//	@Query(value="select * from user_data where user_id=:user_id",nativeQuery=true)
//	UserDataEntity findByUserId(@Param("user_id")long user_id);

}
