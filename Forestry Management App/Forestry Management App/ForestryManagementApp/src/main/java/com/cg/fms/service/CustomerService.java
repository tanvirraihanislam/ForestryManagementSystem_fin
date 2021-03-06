package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Customer;

public interface CustomerService {
	
	public Customer getCustomer(String customerId);

	public boolean addCustomer(Customer customer);

	public boolean updateCustomer(Customer customer);

	public boolean deleteCustomer(String customerId);

	public List<Customer> getAllCustomers();
	
	public String login(String customerId,String customerPassword);

}