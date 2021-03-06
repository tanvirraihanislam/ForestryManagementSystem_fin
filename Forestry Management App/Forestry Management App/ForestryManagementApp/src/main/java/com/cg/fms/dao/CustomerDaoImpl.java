package com.cg.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.cg.fms.dto.Customer;
import com.cg.fms.repo.CustomerRepository;

@Component("CustomerDaoImpl")
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	CustomerRepository customerrepo;

	@Override
	public Customer getCustomer(String customerId) {
		
		if(customerrepo.existsById(customerId)) {
			Optional<Customer> ope = customerrepo.findById(customerId);
			
			if(ope.isPresent()) {
				Customer ct = ope.get();
				return ct;
			}	
		}
		return null;
	}

	@Override
	public void addCustomer(Customer customer) {
			
		if(customerrepo.existsById(customer.getCustomerId())) {
			throw new DuplicateKeyException(null);
		}
		customerrepo.save(customer);
	}

	@Override
	public boolean updateCustomer(Customer customer) {
		if(customerrepo.existsById(customer.getCustomerId())) {
			customerrepo.save(customer);
			return true;
		}
		return false;
	}
	
	@Override
	public boolean deleteCustomer(String customerId) {
		if(customerrepo.existsById(customerId)) {
			customerrepo.deleteById(customerId);
			return true;
		}
		else
			return false;
	}
	
	@Override
	public List<Customer> getAllCustomers() {
		
		List<Customer> list = customerrepo.findAll();
		return list;
	}

	@Override
	public String login(String customerId, String customerPassword) {
		Customer c = customerrepo.searchPassword(customerId,customerPassword);
		if(c == null) {
			return "Login Failed";
		}
		
		return "Login Successful";
	}

}
