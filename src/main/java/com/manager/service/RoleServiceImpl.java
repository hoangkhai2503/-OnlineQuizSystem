package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Role;
import com.manager.repository.RoleRepository;

@Service
public class RoleServiceImpl implements RoleService {
	@Autowired
	private RoleRepository RoleRepository;

	@Override
	public Iterable<Role> findAll() {
		// TODO Auto-generated method stub
		return RoleRepository.findAll();
	}

	@Override
	public Role findById(int id) {
		// TODO Auto-generated method stub
		return RoleRepository.findById(id).get();
	}
}
