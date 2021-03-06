package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Land;

public interface LandService {
	
	public Land getLand(String landId);

	public boolean addLand(Land land);

	public boolean updateLand(Land land);

	public boolean removeLandDetails(String surveyNumber);
	
	public List<Land> getAllLands();
	
	
}
