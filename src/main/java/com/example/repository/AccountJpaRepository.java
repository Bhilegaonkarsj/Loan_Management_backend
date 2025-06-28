package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.entity.AccountsDataEntity;

public interface AccountJpaRepository extends  JpaRepository<AccountsDataEntity, Integer>{

	
	@Query(value="Select * from linked_accounts where account_number=:accountNumber and user_id=:id",nativeQuery=true)
	AccountsDataEntity findByAccountNumberAndUserId(@Param("accountNumber")String accountNumber, @Param("id")Integer id);

	
	@Query(value="Select * from linked_accounts where user_id=:id",nativeQuery=true)
	List<AccountsDataEntity> findByUserId(@Param("id")Integer id);

}
