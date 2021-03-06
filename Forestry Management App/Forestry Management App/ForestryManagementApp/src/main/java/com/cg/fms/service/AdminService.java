package com.cg.fms.service;

import java.util.List;

import com.cg.fms.dto.Admin;

public interface AdminService {
	
	public Admin getAdmin(String adminId);

	public boolean addAdmin(Admin admin);
	
	public boolean updateAdmin(Admin admin);

	public boolean deleteAdmin(String adminId);

	public List<Admin> getAllAdmins();
	
	public List<Admin> getAdminByName(String adminName);
}
