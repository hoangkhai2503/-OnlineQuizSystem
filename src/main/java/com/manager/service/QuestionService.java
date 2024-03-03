package com.manager.service;

import java.util.List;

import com.manager.entities.Question;

public interface QuestionService {
	public Iterable<Question> findAll();
	
	public boolean save(Question question);
	
	public Question findId(int id_question);
	
	public int findIdLatest ();
	
	public boolean saveAll(List<Question> questions);
	
	
 	
}
