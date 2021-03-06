package com.cg.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fms.dto.Order;
import com.cg.fms.exception.OrderException;
import com.cg.fms.repo.OrderRepository;

@Component("OrderDaoImpl")
public class OrderDaoImpl implements OrderDao {
	
	@Autowired
	OrderRepository orderrepo;
	
	@Override
	public Order getOrder(String orderNumber) {
		
		Optional<Order> ope = orderrepo.findById(orderNumber);
		if(ope.isPresent())
			return ope.get();
		
		return null;
	}

	@Override
	public boolean addOrder(Order order) throws OrderException {
		if(orderrepo.existsById(order.getOrderNumber()))
			throw new OrderException("Order with Id "  + order.getOrderNumber() + " is already there"); 
		
		orderrepo.save(order);
		return true;
	}

	@Override
	public boolean updateOrder(Order order) {
		if(orderrepo.existsById(order.getOrderNumber())) {
			orderrepo.save(order);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteOrder(String orderNumber) {
		if(orderrepo.existsById(orderNumber))
			orderrepo.deleteById(orderNumber);
		return false;
	}

	@Override
	public List<Order> getAllOrders() {
		return orderrepo.findAll();
	}

}
