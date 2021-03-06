package com.cg.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.ContractDao;
import com.cg.fms.dto.Contract;
import com.cg.fms.exception.ContractException;

@Service
public class ContractServiceImpl implements ContractService {
	
	@Autowired
	@Qualifier("ContractDaoImpl")
	ContractDao contractdao;
	
	@Override
	public Contract getContract(String contractNumber) {
		
		return contractdao.getContract(contractNumber);	
	}

	@Override
	public boolean addContract(Contract contract) {
		try {
			try {
				contractdao.addContract(contract);
				return true;			// this line added on 4/12/21
			} catch (ContractException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return true;
		} catch (DuplicateKeyException ex) {
			return false;
		}
	}

	@Override
	public List<Contract> getAllContracts() {
		return contractdao.getAllContracts();
	}

	@Override
	public boolean deleteContract(String contractNumber) {
		
		return contractdao.deleteContract(contractNumber);
	}

	@Override
	public boolean updateContract(Contract contract) {
		
		return contractdao.updateContract(contract);
	}
	
	
	
	
}
