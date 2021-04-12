package com.cg.fms.dao;

import java.util.List;

import com.cg.fms.dto.Contract;
import com.cg.fms.exception.ContractException;

public interface ContractDao {
	
	public Contract getContract(String contractNumber);

	public void addContract(Contract contract) throws ContractException;

	public boolean updateContract(Contract contract);

	public boolean deleteContract(String contractNumber);
	
	public List<Contract> getAllContracts();
}
