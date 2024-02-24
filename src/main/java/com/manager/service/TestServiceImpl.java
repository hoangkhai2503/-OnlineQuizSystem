package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Test;
import com.manager.repository.TestRepository;
@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private TestRepository testRepository;
	@Override
	public Iterable<Test> findAll() {
		// TODO Auto-generated method stub
		return testRepository.findAll();
	}

}
