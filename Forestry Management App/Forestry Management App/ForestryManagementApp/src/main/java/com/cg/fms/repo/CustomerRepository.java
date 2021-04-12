package com.cg.fms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Customer;
@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {
	@Query(value="SELECT c FROM Customer c WHERE c.customerId = :customerId and c.customerPassword = :customerPassword")
	Customer searchPassword(@Param("customerId") String customerId,@Param ("customerPassword") String customerPassword);
}
