package com.manager.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Question;
import com.manager.repository.QuestionRepository;

@Service
public class QuestionServiceImpl implements QuestionService {
	@Autowired
	private QuestionRepository questionRepository;

	@Override
	public Iterable<Question> findAll() {
		// TODO Auto-generated method stub
		return questionRepository.findAll();
	}

	@Override
	public boolean save(Question question) {
		try {
			questionRepository.save(question);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Question findId(int id_question) {
		// TODO Auto-generated method stub
		return questionRepository.findById(id_question).get();
	}

	@Override
	public int findIdLatest() {
		// TODO Auto-generated method stub
		return questionRepository.findIdLatest();
	}

	@Override
	public boolean saveAll(List<Question> questions) {
		try {
			questionRepository.saveAll(questions);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
