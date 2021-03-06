package com.cg.fms.dao;

import java.util.List;

import com.cg.fms.dto.Order;
import com.cg.fms.exception.OrderException;

public interface OrderDao {
	
	public Order getOrder(String orderNumber);

	public boolean addOrder(Order order) throws OrderException;

	public boolean updateOrder(Order order);

	public boolean deleteOrder(String orderNumber);
	
	public List<Order> getAllOrders();
}
