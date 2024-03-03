package com.manager.service;

import com.manager.entities.Answer;

public interface AnswerService {
	public Iterable<Answer> findAll();
	
	public boolean save(Answer answer);
}
