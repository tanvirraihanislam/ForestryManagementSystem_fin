package com.cg.fms.controller;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.Contract;
import com.cg.fms.service.ContractService;

@RestController
@RequestMapping("contractDetails")
public class ContractController {
	
	@Autowired
	ContractService contractservice;
	
	@GetMapping("{getContractDetils}")
	public ResponseEntity<?> getContract(@PathVariable("getContractDetils") String contractNumber){
		
		Contract c = contractservice.getContract(contractNumber);
		if(c != null) {
			return new ResponseEntity<Contract>(c, HttpStatus.FOUND);	
		}
		else {
			return new ResponseEntity<String>("Contract details of " + contractNumber + " not found", HttpStatus.NOT_FOUND );
		}
	}
	
	@PostMapping
	public String addContract(@RequestBody Contract contract) {
		if(contractservice.addContract(contract)) {
			return "Contract added successfully";
		}
		else {
			return "no contract found";
		}
	}
	
	@GetMapping
	public List<Contract> getAllContract(){
		return contractservice.getAllContracts();
	}
	
	@DeleteMapping("{contractNumber}")
	public String deleteContract(@PathVariable("contractNumber") String contractNumber) {
		if(contractservice.deleteContract(contractNumber)) {
			return "Contract data is successfully deleted";
		}
		else
			return "Contract with " + contractNumber + " contract number is not found" ;
	}
	
	@PutMapping
	public String updateContract(@RequestBody Contract contract) {
		if(contractservice.updateContract(contract)) {
			return "Successfully updated";
		}
		return "Contract to update not found ";
	}
	
	
	
}
