package com.manager.service;

import java.util.List;

import com.manager.entities.Teacher;

public interface TeacherService {
	public Iterable<Teacher> findAll();
	
	public List<Teacher> findAllTeacherActive();
	
	public List<Teacher> findAllTeacherInactive();
	
	public boolean save (Teacher teacher);
	
	public Teacher findById(int id);
	
	public boolean delete(int id);
	
	public List<Teacher> searchTeacherByKeyword(String keyword);
}