package com.manager.service;

import com.manager.entities.Role;

public interface RoleService {
	public Iterable<Role> findAll();
	public Role findById(int id);
}
