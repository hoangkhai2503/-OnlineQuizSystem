package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Answer;
import com.manager.entities._Class;
import com.manager.repository.ClassRepository;
@Service
public class ClassServiceImpl implements ClassService{
	@Autowired
	private ClassRepository classRepository;
	@Override
	public Iterable<_Class> findAll() {
		// TODO Auto-generated method stub
		return classRepository.findAll();
	}
	
	@Override
	public boolean save(_Class _class) {
		try {
			classRepository.save(_class);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public _Class findId(int id_class) {
		// TODO Auto-generated method stub
		return classRepository.findById(id_class).get();
	}

	@Override
	public int findIdLatest() {
		// TODO Auto-generated method stub
		return classRepository.findIdLatest();
	}

}