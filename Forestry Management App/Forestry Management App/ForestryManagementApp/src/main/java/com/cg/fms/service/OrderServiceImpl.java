package com.cg.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.OrderDao;
import com.cg.fms.dto.Order;
import com.cg.fms.exception.OrderException;

@Service
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	@Qualifier("OrderDaoImpl")
	OrderDao orderdao;
	
	@Override
	public Order getOrder(String orderNumber) {
		return orderdao.getOrder(orderNumber);
	}

	@Override
	public boolean addOrder(Order order) {
		try {
			orderdao.addOrder(order);
			return true;
		} catch (OrderException e) {
			return false;
		}
		
	}

	@Override
	public boolean updateOrder(Order order) {
		
		return orderdao.updateOrder(order);
	}

	@Override
	public boolean deleteOrder(String orderNumber) {
		
		return orderdao.deleteOrder(orderNumber);
	}

	@Override
	public List<Order> getAllOrders() {
		
		return orderdao.getAllOrders();
	}

}
