package com.cg.fms.repo;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Contract;

@Repository
public interface ContractRepository extends JpaRepository<Contract, String> {
	
	Optional<Contract> findById(String contractNumber);
	
	List<Contract> findByQuotation(String quotation);
}
