package com.cg.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.SchedulerDao;
import com.cg.fms.dto.Scheduler;
import com.cg.fms.exception.SchedulerException;

@Service
public class SchedulerServiceImpl implements SchedulerService{
	
	@Autowired
	@Qualifier("SchedulerDaoImpl")
	SchedulerDao schedDao;

	@Override
	public Scheduler getScheduler(String schedulerId) {
		
		return schedDao.getScheduler(schedulerId);
	}

	@Override
	public boolean addScheduler(Scheduler scheduler) {
		try {
			schedDao.addScheduler(scheduler);
			return true;
		}catch(SchedulerException se) {
			return false;
		}
	}

	@Override
	public boolean updateScheduler(Scheduler scheduler) {
		return schedDao.updateScheduler(scheduler);
	}

	@Override
	public boolean deleteScheduler(String schedulerId) {
		return schedDao.deleteScheduler(schedulerId);
	}

	@Override
	public List<Scheduler> getAllSchedulers() {
		return schedDao.getAllSchedulers();
	}

}
