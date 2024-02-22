package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Variable;
import com.manager.repository.VariableRepository;
@Service
public class VariableServiceImpl implements VariableService{
	@Autowired
	private VariableRepository variableRepository;
	@Override
	public Iterable<Variable> findAll() {
		// TODO Auto-generated method stub
		return variableRepository.findAll();
	}

}
