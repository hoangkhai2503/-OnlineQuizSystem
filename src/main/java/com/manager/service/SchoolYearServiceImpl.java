package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Answer;
import com.manager.entities.SchoolYear;
import com.manager.repository.AnswerRepository;
import com.manager.repository.SchoolYearRepository;
@Service
public class SchoolYearServiceImpl implements SchoolYearService{
	@Autowired
	private SchoolYearRepository schoolYearRepository;
	@Override
	public Iterable<SchoolYear> findAll() {
		// TODO Auto-generated method stub
		return schoolYearRepository.findAll();
	}
	
}