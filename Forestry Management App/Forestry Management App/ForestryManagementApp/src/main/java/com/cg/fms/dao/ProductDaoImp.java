package com.cg.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fms.dto.Product;
import com.cg.fms.exception.ProductException;
import com.cg.fms.repo.ProductRepository;

@Component("ProductDaoImpl")
public class ProductDaoImp implements ProductDao {

	@Autowired
	ProductRepository productrepo;

	@Override
	public Product getProduct(String productId) {
		// TODO Auto-generated method stub
		if (productrepo.existsById(productId)) {
			Optional<Product> op = productrepo.findById(productId);
			if (op.isPresent()) {
				Product p = op.get();
				return p;
			}
		}
		return null;
	}

	@Override
	public void addProduct(Product product) throws ProductException {
		
		if (productrepo.existsById(product.getProductId())) {
			throw new ProductException("Product already present");
		}
		else {
			productrepo.save(product);
		}
		
		
	}

	@Override
	public boolean updateProduct(Product product) {
		// TODO Auto-generated method stub
		if (productrepo.existsById(product.getProductId())) {
			productrepo.save(product);
			return true;
		}

		return false;
	}

	@Override
	public boolean deleteProduct(String productId) {
		// TODO Auto-generated method stub
		if(productrepo.existsById(productId)) {
			productrepo.deleteById(productId);
			return true;
		}
		return false;
	}

	@Override
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub
		List<Product> list=(List<Product>)productrepo.findAll();
		return list;
	}

}