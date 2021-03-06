package com.cg.fms.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.cg.fms.dto.Admin;
import com.cg.fms.exception.AdminException;
import com.cg.fms.repo.AdminRepository;

@Component("AdminDaoImpl")
public class AdminDaoImpl implements AdminDao {

	@Autowired
	AdminRepository adminRepo;

	@Override
	public Admin getAdmin(String adminId) {
		
			Optional<Admin> ope = adminRepo.findById(adminId);
			if (ope.isPresent()) {
				return ope.get();
			}
		
		return null;
	}

	@Override
	public List<Admin> getAllAdmins() {
		return (List<Admin>) adminRepo.findAll();
	}

	@Override
	public void addAdmin(Admin admin) throws AdminException {
		if(adminRepo.existsById(admin.getAdminId())) {
			throw new AdminException("Admin with ID "+ admin.getAdminId()+" is already there");
		}
		adminRepo.save(admin);	
		
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		if(adminRepo.existsById(admin.getAdminId())) {
			adminRepo.save(admin);
			return true;
		}
		return false;
	}

	@Override
	public boolean deleteAdmin(String adminId) {
		if(adminRepo.existsById(adminId)) {
			adminRepo.deleteById(adminId);
		}
		return false;
	}

	@Override
	public List<Admin> getAdminByName(String adminName) {
		
			return (List<Admin>) adminRepo.findByName(adminName);
	}

}
