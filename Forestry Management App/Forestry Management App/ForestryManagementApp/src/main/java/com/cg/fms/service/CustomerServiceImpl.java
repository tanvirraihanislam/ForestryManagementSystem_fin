package com.cg.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.CustomerDao;
import com.cg.fms.dto.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	@Qualifier("CustomerDaoImpl")
	CustomerDao customerdao;

	@Override
	public Customer getCustomer(String customerId) {

		return customerdao.getCustomer(customerId);
	}

	@Override
	public boolean addCustomer(Customer customer) {
		try {
			customerdao.addCustomer(customer);
			return true;
		} catch (DuplicateKeyException ex) {
			return false;
		}
	}

	@Override
	public boolean updateCustomer(Customer customer) {

		return customerdao.updateCustomer(customer);
	}
	
	@Override
	public boolean deleteCustomer(String customerId) {

		return customerdao.deleteCustomer(customerId);
	}

	@Override
	public List<Customer> getAllCustomers() {
		return customerdao.getAllCustomers();
	}

	@Override
	public String login(String customerId, String customerPassword) {
		return customerdao.login(customerId, customerPassword);
	}

}
