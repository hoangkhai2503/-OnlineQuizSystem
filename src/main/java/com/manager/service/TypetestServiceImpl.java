package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Typetest;
import com.manager.repository.TypeTestRepository;
@Service
public class TypetestServiceImpl implements TypetestService{
	@Autowired
	private TypeTestRepository typeTestRepository;
	@Override
	public Iterable<Typetest> findAll() {
		// TODO Auto-generated method stub
		return typeTestRepository.findAll();
	}

}
