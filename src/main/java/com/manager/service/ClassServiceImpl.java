package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Class;
import com.manager.repository.ClassRepository;
@Service
public class ClassServiceImpl implements ClassService{
	@Autowired
	private ClassRepository classRepository;
	@Override
	public Iterable<Class> findAll() {
		// TODO Auto-generated method stub
		return classRepository.findAll();
	}

}
