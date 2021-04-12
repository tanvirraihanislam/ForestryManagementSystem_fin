package com.cg.fms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Land;

@Repository
public interface LandRepository extends JpaRepository<Land, String> {

}
