package com.cg.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.cg.fms.dto.Contract;
import com.cg.fms.exception.ContractException;
import com.cg.fms.repo.ContractRepository;

@Component("ContractDaoImpl")
public class ContractDaoImpl implements ContractDao {
	
	@Autowired
	ContractRepository contractRepo;

	@Override
	public Contract getContract(String contractNumber) {
		
		if(contractRepo.existsById(contractNumber)) {
			Optional<Contract> ope = contractRepo.findById(contractNumber);
			
			if(ope.isPresent()) {
				Contract ct = ope.get();
				return ct;
			}	
		}
		return null;
	}

	@Override
	public void addContract(Contract contract) throws ContractException {
			
		if(contractRepo.existsById(contract.getContractNumber())) {
			throw new ContractException("Contract with Id " + contract.getContractNumber()+ " is already present");
		}
		contractRepo.save(contract);
	}

	@Override
	public List<Contract> getAllContracts() {
		
		List<Contract> list = contractRepo.findAll();
		return list;
	}

	@Override
	public boolean deleteContract(String contractNumber) {
		if(contractRepo.existsById(contractNumber)) {
			contractRepo.deleteById(contractNumber);
			return true;
		}
		else
			return false;
	}

	@Override
	public boolean updateContract(Contract contract) {
		if(contractRepo.existsById(contract.getContractNumber())) {
			contractRepo.save(contract);
			return true;
		}
		return false;
	}
	
	
}
