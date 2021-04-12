package com.cg.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.ProductDao;
import com.cg.fms.dto.Product;
import com.cg.fms.exception.ProductException;
import com.cg.fms.repo.ProductRepository;
@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	@Qualifier("ProductDaoImpl")
	ProductDao productdao;
	
	@Override
	public Product getProduct(String productId) {
		
		return	productdao.getProduct(productId);
		
	}

	@Override
	public boolean addProduct(Product product) {
		try {
		 productdao.addProduct(product);
		 return true;
		}catch(ProductException ex) {
			return false;
		}
	}

	@Override
	public boolean updateProduct(Product product) {
		
		return productdao.updateProduct(product);
	}

	@Override
	public boolean deleteProduct(String productId) {
		
		return productdao.deleteProduct(productId);
	}

	@Override
	public List<Product> getAllProducts() {
		
		return productdao.getAllProducts();
	}
    
	

	
}