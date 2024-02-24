package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Answer;

@Repository
public interface AnswerRepository extends CrudRepository<Answer, Integer>{

}
