package com.cg.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.cg.fms.dto.Scheduler;
import com.cg.fms.exception.SchedulerException;
import com.cg.fms.repo.SchedulerRepository;


@Component("SchedulerDaoImpl")
public class SchedulerDaoImpl implements SchedulerDao{
	
	@Autowired
	SchedulerRepository schedRepo;

	@Override
	public Scheduler getScheduler(String schedulerId) {
		if(schedRepo.existsById(schedulerId)) {
			Optional<Scheduler> ope = schedRepo.findById(schedulerId);
			
			if(ope.isPresent()) {
				Scheduler sc = ope.get();
				return sc;
			}
		}
		return null;
	}

	@Override
	public void addScheduler(Scheduler scheduler) throws SchedulerException {
		if(schedRepo.existsById(scheduler.getSchedulerId())) {
			throw new SchedulerException("Scheduler with ID "+scheduler.getSchedulerId()+" exists already");
		}
		schedRepo.save(scheduler);
		
	}

	@Override
	public boolean updateScheduler(Scheduler scheduler) {
		if(schedRepo.existsById(scheduler.getSchedulerId())) {
			schedRepo.save(scheduler);
			return true;
		}
		return false;
		
	}

	@Override
	public boolean deleteScheduler(String schedulerId) {
		if(schedRepo.existsById(schedulerId)) {
			schedRepo.deleteById(schedulerId);
			return true;
		}
		return false;
	}

	@Override
	public List<Scheduler> getAllSchedulers() {
		return (List<Scheduler>) schedRepo.findAll();
	}

}
