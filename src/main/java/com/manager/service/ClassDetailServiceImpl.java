package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.ClassDetail;
import com.manager.repository.ClassDetailRepository;
@Service
public class ClassDetailServiceImpl implements ClassDetailService{
	@Autowired
	private ClassDetailRepository classDetailRepository;
	@Override
	public Iterable<ClassDetail> findAll() {
		// TODO Auto-generated method stub
		return classDetailRepository.findAll();
	}

}
