package com.manager.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.manager.entities.Student;

public interface StudentService extends UserDetailsService{
	public Iterable<Student> findAll();
	
	public Student findId(int id_student);
	
	public boolean save(Student student);
	
	public Student loginStudent(String email_student, String password_student);
	
	public Student findByEmailStudent(String email_student);
}