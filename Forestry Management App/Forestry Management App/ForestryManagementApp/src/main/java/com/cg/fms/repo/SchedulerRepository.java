package com.cg.fms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.fms.dto.Scheduler;

@Repository
public interface SchedulerRepository extends JpaRepository<Scheduler, String>{

}
