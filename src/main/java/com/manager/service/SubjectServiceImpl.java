package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Subject;
import com.manager.repository.SubjectRepository;
@Service
public class SubjectServiceImpl implements SubjectService{
	@Autowired
	private SubjectRepository subjectRepository;
	@Override
	public Iterable<Subject> findAll() {
		// TODO Auto-generated method stub
		return subjectRepository.findAll();
	}

}
