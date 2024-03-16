package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entities.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer>{

	@Query("from Answer where question.id_question = :id_question")
	public List<Answer> findByIdQuestion(@Param("id_question") int id_question);
	
}