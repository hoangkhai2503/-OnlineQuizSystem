package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Variable;
import com.manager.repository.VariableRepository;

@Service
public class VariableServiceImpl implements VariableService {
	@Autowired
	private VariableRepository variableRepository;

	@Override
	public Iterable<Variable> findAll() {
		// TODO Auto-generated method stub
		return variableRepository.findAll();
	}

	@Override
	public boolean save(Variable variable) {
		try {
			variableRepository.save(variable);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Variable findById(int id) {
		// TODO Auto-generated method stub
		return variableRepository.findById(id).get();
	}

	@Override
	public boolean delete(int id) {
		try {
			variableRepository.delete(findById(id));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
