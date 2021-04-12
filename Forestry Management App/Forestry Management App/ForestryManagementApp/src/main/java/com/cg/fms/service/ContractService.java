package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Contract;

public interface ContractService {

	public Contract getContract(String contractNumber);
	public boolean addContract(Contract contract);
	public boolean updateContract(Contract contract);
	public boolean deleteContract(String contractNumber);
	public List<Contract> getAllContracts();
}
