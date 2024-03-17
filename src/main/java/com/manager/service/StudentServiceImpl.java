package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Student;
import com.manager.repository.StudentRepository;
@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentRepository studentRepository;
	@Override
	public Iterable<Student> findAll() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	@Override
	public Student findId(int id_student) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id_student).get();
	}
	@Override
	public boolean save(Student student) {
		try {
			studentRepository.save(student);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}