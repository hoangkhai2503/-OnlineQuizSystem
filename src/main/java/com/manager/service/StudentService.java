package com.manager.service;

import com.manager.entities.Student;

public interface StudentService {
	public Iterable<Student> findAll();
	
	public Student findId(int id_student);
	
	public boolean save(Student student);
}
