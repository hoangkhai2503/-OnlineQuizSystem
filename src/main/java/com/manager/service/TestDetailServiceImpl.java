package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.TestDetail;
import com.manager.repository.TestDetailRepository;
@Service
public class TestDetailServiceImpl implements TestDetailService{
	@Autowired
	private TestDetailRepository testDetailRepository;
	@Override
	public Iterable<TestDetail> findAll() {
		// TODO Auto-generated method stub
		return testDetailRepository.findAll();
	}

}
