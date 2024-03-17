package com.manager.service;

import org.springframework.data.repository.query.Param;

import com.manager.entities.TestDetail;

public interface TestDetailService {
	public Iterable<TestDetail> findAll();
	
	public boolean save(TestDetail testDetail);
	
	public TestDetail findId(int id_testDetail);
	
	public int findIdLatest ();
	
	public TestDetail findByIdStudentAndIdTest(int idStudent,int idTest);
}