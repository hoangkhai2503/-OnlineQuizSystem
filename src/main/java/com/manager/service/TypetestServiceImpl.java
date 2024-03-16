package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Typetest;
import com.manager.repository.TypeTestRepository;

@Service
public class TypetestServiceImpl implements TypetestService {
	@Autowired
	private TypeTestRepository typeTestRepository;

	@Override
	public Iterable<Typetest> findAll() {
		// TODO Auto-generated method stub
		return typeTestRepository.findAll();
	}

	@Override
	public boolean save(Typetest typetest) {
		try {
			typeTestRepository.save(typetest);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Typetest findById(int id) {
		// TODO Auto-generated method stub
		return typeTestRepository.findById(id).get();
	}

	@Override
	public boolean delete(int id) {
		// TODO Auto-generated method stub
		return false;
	}
}
