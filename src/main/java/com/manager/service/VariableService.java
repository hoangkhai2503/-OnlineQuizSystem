package com.manager.service;

import com.manager.entities.Variable;

public interface VariableService {
	public Iterable<Variable> findAll();
	public Variable findByCode_variable( String code_variable); 
}
