package com.manager.service;

import com.manager.entities.Question;
import java.util.List;
public interface QuestionService {
	public Iterable<Question> findAll();
	public boolean save(Question question);

	public Question findId(int id_question);

	public int findIdLatest ();

	public boolean saveAll(List<Question> questions);
}
