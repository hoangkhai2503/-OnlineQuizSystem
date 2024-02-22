package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Question;
import com.manager.repository.QuestionRepository;
@Service
public class QuestionServiceImpl implements QuestionService{
	@Autowired
	private QuestionRepository questionRepository;
	@Override
	public Iterable<Question> findAll() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}

}
