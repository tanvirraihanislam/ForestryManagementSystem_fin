package com.cg.fms.dao;


import java.util.List;

import com.cg.fms.dto.Land;
import com.cg.fms.exception.LandException;

public interface LandDao {
	
	public Land getLand(String landId);

	public void addLand(Land land) throws LandException;

	public boolean updateLand(Land land);

	public boolean deleteLand(String surveyNumber);
	
	public List<Land> getAllLands();
	
}
