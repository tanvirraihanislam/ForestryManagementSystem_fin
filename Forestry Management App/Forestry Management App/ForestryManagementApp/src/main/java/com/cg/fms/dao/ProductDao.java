package com.cg.fms.dao;

import java.util.List;

import org.springframework.stereotype.Component;

import com.cg.fms.dto.Product;
import com.cg.fms.exception.ProductException;


@Component
public interface ProductDao {

	public Product getProduct(String productId);

	public void addProduct(Product product) throws ProductException;

	public boolean updateProduct(Product product);

	public boolean deleteProduct(String productId);
	
	public List<Product> getAllProducts();

}