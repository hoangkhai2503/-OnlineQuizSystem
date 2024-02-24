package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Resulttest;
import com.manager.repository.ResultTestRepository;
@Service
public class ResultTestServiceImpl implements ResultTestService{
	@Autowired
	private ResultTestRepository resultTestRepository;
	@Override
	public Iterable<Resulttest> findAll() {
		// TODO Auto-generated method stub
		return resultTestRepository.findAll();
	}

}
