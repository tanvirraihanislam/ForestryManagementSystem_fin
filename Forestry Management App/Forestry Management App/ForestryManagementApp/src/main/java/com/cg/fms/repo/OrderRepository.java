package com.cg.fms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {

}
