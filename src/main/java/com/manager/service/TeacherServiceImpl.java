package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Teacher;
import com.manager.repository.TeacherRepository;
@Service
public class TeacherServiceImpl implements TeacherService{
	@Autowired
	private TeacherRepository teacherRepository;
	@Override
	public Iterable<Teacher> findAll() {
		// TODO Auto-generated method stub
		return teacherRepository.findAll();
	}

}
