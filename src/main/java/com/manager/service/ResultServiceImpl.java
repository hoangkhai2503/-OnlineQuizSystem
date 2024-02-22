package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Result;
import com.manager.repository.ResultRepository;
@Service
public class ResultServiceImpl implements ResultService{
	@Autowired
	private ResultRepository resultRepository;
	@Override
	public Iterable<Result> findAll() {
		// TODO Auto-generated method stub
		return resultRepository.findAll();
	}

}
