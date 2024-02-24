package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Superadmin;
import com.manager.repository.SuperAdminRepository;
@Service
public class SuperAdminServiceImpl implements SuperAdminService{
	@Autowired
	private SuperAdminRepository superAdminRepository;
	@Override
	public Iterable<Superadmin> findAll() {
		// TODO Auto-generated method stub
		return superAdminRepository.findAll();
	}

}
