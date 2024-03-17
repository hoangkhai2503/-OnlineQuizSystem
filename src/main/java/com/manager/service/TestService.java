package com.manager.service;

import com.manager.entities.Test;

public interface TestService {
	public Iterable<Test> findAll();
	
	public boolean save(Test test);
	
	public Test findId(int id_test);
}