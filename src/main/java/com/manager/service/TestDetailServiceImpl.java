package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.TestDetail;
import com.manager.entities._Class;
import com.manager.repository.TestDetailRepository;
@Service
public class TestDetailServiceImpl implements TestDetailService{
	@Autowired
	private TestDetailRepository testDetailRepository;
	@Override
	public Iterable<TestDetail> findAll() {
		// TODO Auto-generated method stub
		return testDetailRepository.findAll();
	}
	@Override
	public boolean save(TestDetail testDetail) {
		try {
			testDetailRepository.save(testDetail);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public TestDetail findId(int id_testDetail) {
		// TODO Auto-generated method stub
		return testDetailRepository.findById(id_testDetail).get();
	}
	@Override
	public int findIdLatest() {
		// TODO Auto-generated method stub
		return testDetailRepository.findIdLatest();
	}
	@Override
	public TestDetail findByIdStudentAndIdTest(int idStudent, int idTest) {
		// TODO Auto-generated method stub
		return testDetailRepository.findByIdStudentAndIdTest(idStudent, idTest);
	}


}