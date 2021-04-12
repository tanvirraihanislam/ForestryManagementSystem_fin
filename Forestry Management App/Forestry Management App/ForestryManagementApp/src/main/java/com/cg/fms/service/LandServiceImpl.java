package com.cg.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.LandDao;
import com.cg.fms.dto.Land;
import com.cg.fms.exception.LandException;

@Service
public class LandServiceImpl implements LandService {
	
	@Autowired
	@Qualifier("LandDaoImpl")
	LandDao landdao;
	
	@Override
	public Land getLand(String landId) {
		
		return landdao.getLand(landId);
	}

	@Override
	public boolean addLand(Land land) {
		try {
		try {
			landdao.addLand(land);
		} catch (LandException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return true;
		}catch (DuplicateKeyException ex) {
			return false;
		}
	}

	@Override
	public boolean updateLand(Land land) {
		
		return landdao.updateLand(land);
	}

	@Override
	public boolean removeLandDetails(String surveyNumber) {
		
		return landdao.deleteLand(surveyNumber);
	}

	@Override
	public List<Land> getAllLands() {
		
		return landdao.getAllLands();
	}

}
