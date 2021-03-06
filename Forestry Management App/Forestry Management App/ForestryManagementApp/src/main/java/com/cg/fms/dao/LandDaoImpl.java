package com.cg.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Component;

import com.cg.fms.dto.Land;
import com.cg.fms.exception.LandException;
import com.cg.fms.repo.LandRepository;

@Component("LandDaoImpl")
public class LandDaoImpl implements LandDao {
	
	@Autowired
	LandRepository landrepo;

	@Override
	public Land getLand(String landId) {
		
			Optional<Land> opt = landrepo.findById(landId);
			if(opt.isPresent()) {
				return opt.get();
			}
			else
				return null;
	}

	@Override
	public void addLand(Land land) throws LandException {
		
		if(landrepo.existsById(land.getLandId())) {
			throw new LandException("Land Id " + land.getLandId() + " is already present");
		}
		landrepo.save(land);
	}

	@Override
	public boolean updateLand(Land land) {
		
		if(landrepo.existsById(land.getLandId())) {
			landrepo.save(land);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteLand(String surveyNumber) {
		
		if(landrepo.existsById(surveyNumber)) {
			landrepo.deleteById(surveyNumber);
		}
		return false;
	}

	@Override
	public List<Land> getAllLands() {
		return landrepo.findAll();
	}

}
