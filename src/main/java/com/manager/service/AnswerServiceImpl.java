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
	@Override
	public boolean save(Answer answer) {
		try {
			answerRepository.save(answer);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Iterable<Answer> findByIdQuestion(int id_question) {
		// TODO Auto-generated method stub
		return answerRepository.findByIdQuestion(id_question);
	}
	@Override
	public Answer findId(int id_answer) {
		// TODO Auto-generated method stub
		return answerRepository.findById(id_answer).get();
	}
}