package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Test;
import com.manager.entities._Class;
import com.manager.repository.TestRepository;
@Service
public class TestServiceImpl implements TestService{
	@Autowired
	private TestRepository testRepository;
	@Override
	public Iterable<Test> findAll() {
		// TODO Auto-generated method stub
		return testRepository.findAll();
	}
	@Override
	public boolean save(Test test) {
		try {
			testRepository.save(test);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Test findId(int id_test) {
		// TODO Auto-generated method stub
		return testRepository.findById(id_test).get();
	}

}