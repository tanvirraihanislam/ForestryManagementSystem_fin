package com.cg.fms.dao;

import java.util.List;

import com.cg.fms.dto.Scheduler;
import com.cg.fms.exception.SchedulerException;

public interface SchedulerDao {
	public Scheduler getScheduler(String schedulerId);

	public void addScheduler(Scheduler scheduler) throws SchedulerException;

	public boolean updateScheduler(Scheduler scheduler);

	public boolean deleteScheduler(String schedulerId);

	public List<Scheduler> getAllSchedulers();
}
