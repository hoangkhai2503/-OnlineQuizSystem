package com.manager.service;

import com.manager.entities.Variable;

public interface VariableService {
	public Iterable<Variable> findAll();
    public boolean save (Variable  variable);

	public Variable findById(int id);

	public boolean delete(int id);
}
