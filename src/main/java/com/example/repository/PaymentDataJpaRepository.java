package com.example.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.PaymentDataEntity;

public interface PaymentDataJpaRepository extends  JpaRepository<PaymentDataEntity, Integer>{

	
	@Query(value="select * from payments where user_id=:userId and loan_id=:loanId order by created_at desc",nativeQuery=true)
	List<PaymentDataEntity> findByLoanIdAndUserId(@Param("loanId")Integer loanId, @Param("userId")Integer userId);

	
	@Query(value="select * from payments  where user_id=:userId and account_number in :accounIds order by created_at desc",nativeQuery=true)
	List<PaymentDataEntity> findByUserIdAndAccountNumbers(@Param("userId")Integer userId, @Param("accountIds")List<String> accountIds);

	@Query(value="select * from payments where user_id=:userId  order by created_at desc",nativeQuery=true)
	List<PaymentDataEntity> findByUserId(@Param("userId")Integer userId);

	
//	@Query(value="select * from user_data where user_id=:user_id",nativeQuery=true)
//	UserDataEntity findByUserId(@Param("user_id")long user_id);

}
