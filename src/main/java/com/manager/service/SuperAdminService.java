package com.manager.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.manager.entities.Superadmin;

public interface SuperAdminService extends UserDetailsService{
	public Iterable<Superadmin> findAll();
	
	public boolean save(Superadmin superadmin);
	
	public Superadmin loginAdmin(String username_superadmin, String password_superadmin);
	
	public Superadmin findByUsernameAdmin(String username_superadmin);
}
