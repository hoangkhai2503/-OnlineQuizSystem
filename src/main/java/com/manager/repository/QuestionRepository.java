package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer>{

}
