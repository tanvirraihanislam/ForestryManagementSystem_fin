package com.cg.fms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, String> {

}