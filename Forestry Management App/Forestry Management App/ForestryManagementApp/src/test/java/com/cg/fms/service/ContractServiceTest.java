package com.cg.fms.service;

import static org.hamcrest.CoreMatchers.any;
import static org.hamcrest.CoreMatchers.containsString;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.exceptions.base.MockitoException;
import org.springframework.boot.test.context.SpringBootTest;

import static org.mockito.ArgumentMatchers.any;

import com.cg.fms.dao.ContractDao;
import com.cg.fms.dao.ContractDaoImpl;
import com.cg.fms.dto.Contract;
import com.cg.fms.repo.ContractRepository;

@SpringBootTest
public class ContractServiceTest {

	@Mock
	private ContractRepository contractrepo;
	
	@InjectMocks
	private ContractDaoImpl contractdao;
	private ContractServiceImpl contractservice;
	private Contract contract;
	private List<Contract> contractList;
	private Optional optional;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		String startDate = "03/05/2018";
		String endDate = "10/11/2020";
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
		Date strdate = null;
		Date enddate = null;
		try {
			strdate = df.parse(startDate);
			enddate = df.parse(endDate);
		} catch (ParseException e1) {
			System.out.println("wrong date formate");
			e1.printStackTrace();
		}
		
		contract = new Contract(null, null, null, null, null);
		contract.setContractNumber("101");
		contract.setQuotation("500000");
		contract.setStartDate(strdate);
		contract.setEndDate(enddate);
		contract.setContractStatus("approved");
		
		optional = Optional.of(contract);
	}
	
	@AfterEach
	public void tearDown() {
		contract = null;
	}
	
	@Test
	void givenContractTosavethenShouldreturnSavedContract() {
		
		when(contractrepo.save(any())).thenReturn(contract);
		
//		System.out.print(contractdao.addContract(contract));
		
		assertEquals(null, contractservice.addContract(contract));
		verify(contractrepo, times(1)).save(any());
	}
	
	
	
}
