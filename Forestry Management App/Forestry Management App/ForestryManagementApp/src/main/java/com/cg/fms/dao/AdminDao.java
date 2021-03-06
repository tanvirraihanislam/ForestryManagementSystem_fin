package com.cg.fms.dao;

import java.util.List;

import com.cg.fms.dto.Admin;
import com.cg.fms.exception.AdminException;

public interface AdminDao {
	public Admin getAdmin(String adminId);

	public void addAdmin(Admin admin) throws AdminException;
	
	public boolean updateAdmin(Admin admin);

	public boolean deleteAdmin(String adminName);
	
	public List<Admin> getAllAdmins();
	
	public List<Admin> getAdminByName(String adminName);
}
