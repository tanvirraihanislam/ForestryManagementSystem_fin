package com.cg.fms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.fms.dto.Product;
import com.cg.fms.service.ProductService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@RestController
@EnableSwagger2
@RequestMapping("productDetails")
public class PoductControlle{

	@Autowired
	ProductService productservice;
	
	@GetMapping("{pid}")
	public ResponseEntity<?> getProduct(@PathVariable("pid")String productId){
		Product p=productservice.getProduct(productId);
		if(p==null)
			return new ResponseEntity<String>("product with "+productId+" not found ",HttpStatus.NOT_FOUND);
	return new ResponseEntity<Product>(p,HttpStatus.OK);
	}
	
	@GetMapping
	public List<Product> getAllProducts(){
		return productservice.getAllProducts();
	}
	
	@PostMapping
	public String saveProduct(@RequestBody Product p) {
		if(productservice.addProduct(p))
			return "product addition success";
		return "product addition failed";
	}
	@PutMapping
	public String updateProduct(@RequestBody Product p) {
		if(productservice.updateProduct(p))
			return "product updated";
		return "product not found and not updated";
	}
	public String deleteProduct(String productId) {
		if(productservice.deleteProduct(productId))
			return "product deleted";
		return "product not deleted";
	}
	
}