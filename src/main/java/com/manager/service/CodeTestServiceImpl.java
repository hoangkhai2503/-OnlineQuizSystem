package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Codetest;
import com.manager.repository.CodeTestRepository;
@Service
public class CodeTestServiceImpl implements CodeTestService{
	@Autowired
	private CodeTestRepository codeTestRepository;
	@Override
	public Iterable<Codetest> findAll() {
		// TODO Auto-generated method stub
		return codeTestRepository.findAll();
	}

}
