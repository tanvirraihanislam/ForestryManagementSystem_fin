package com.cg.fms.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.cg.fms.dao.AdminDao;
import com.cg.fms.dto.Admin;
import com.cg.fms.exception.AdminException;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	@Qualifier("AdminDaoImpl")
	AdminDao admindao;

	@Override
	public Admin getAdmin(String adminId) {
		return admindao.getAdmin(adminId);
	}

	@Override
	public List<Admin> getAllAdmins() {
		return admindao.getAllAdmins();
	}

	@Override
	public boolean addAdmin(Admin admin) {
		try {
			admindao.addAdmin(admin);
			return true;
		}catch(AdminException ae) {
			return false;
		}
		
	}

	@Override
	public boolean updateAdmin(Admin admin) {
		
		return admindao.updateAdmin(admin);
	}

	@Override
	public boolean deleteAdmin(String adminId) {
		return admindao.deleteAdmin(adminId);
	}

	@Override
	public List<Admin> getAdminByName(String adminName) {
		
		return admindao.getAdminByName(adminName);
	}

}
