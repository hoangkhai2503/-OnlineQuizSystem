package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.manager.entities.Question;

@Repository
public interface QuestionRepository extends CrudRepository<Question, Integer>{
	@Query("select max(id_question) from Question")
	public int findIdLatest();
}
