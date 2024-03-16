package com.manager.service;

import java.util.List;

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
	@Override
	public boolean save(Teacher teacher) {
		try {
			teacherRepository.save(teacher);
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public Teacher findById(int id) {
		return teacherRepository.findById(id).get();
	}
	@Override
	public boolean delete(int id) {
		try {
			teacherRepository.delete(findById(id));
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List<Teacher> findAllTeacherActive() {
		// TODO Auto-generated method stub
		return teacherRepository.findAllTeacherActive();
	}
	@Override
	public List<Teacher> findAllTeacherInactive() {
		// TODO Auto-generated method stub
		return teacherRepository.findAllTeacherInactive();
	}
	@Override
	public List<Teacher> searchTeacherByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return teacherRepository.searchTeacherByKeyword(keyword);
	}

}