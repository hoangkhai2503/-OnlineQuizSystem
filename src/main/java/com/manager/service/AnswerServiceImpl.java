package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Answer;
import com.manager.repository.AnswerRepository;
@Service
public class AnswerServiceImpl implements AnswerService{
	@Autowired
	private AnswerRepository answerRepository;
	@Override
	public Iterable<Answer> findAll() {
		// TODO Auto-generated method stub
		return answerRepository.findAll();
	}

}
