package com.manager.service;

import com.manager.entities.Superadmin;
import org.springframework.security.core.userdetails.UserDetailsService;
public interface SuperAdminService extends UserDetailsService{
	public Iterable<Superadmin> findAll();
	
	public boolean save(Superadmin superadmin);

	public Superadmin loginAdmin(String username_superadmin, String password_superadmin);
//
	public Superadmin findByUsernameAdmin(String username_superadmin);
	
	
}
