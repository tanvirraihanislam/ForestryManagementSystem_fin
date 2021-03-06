package com.cg.fms.dao;

import java.util.List;

import com.cg.fms.dto.Customer;

public interface CustomerDao {
	
	public Customer getCustomer(String customerId);

	public void addCustomer(Customer customer);

	public boolean updateCustomer(Customer customer);

	public boolean deleteCustomer(String customerId);

	public List<Customer> getAllCustomers();
	
	public String login(String customerId,String customerPassword);

	
}