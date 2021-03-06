package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Order;

public interface OrderService {
	
	public Order getOrder(String orderNumber);

	public boolean addOrder(Order order);

	public boolean updateOrder(Order order);

	public boolean deleteOrder(String orderNumber);
	
	public List<Order> getAllOrders();
}
