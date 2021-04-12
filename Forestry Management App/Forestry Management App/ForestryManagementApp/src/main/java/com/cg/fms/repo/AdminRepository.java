package com.cg.fms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Admin;

@Repository
public interface AdminRepository extends JpaRepository<Admin, String> {
	@Query(value="SELECT a FROM Admin a WHERE a.adminName = :adminName")
	List<Admin> findByName(@Param ("adminName") String adminName);

}
