package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Term;

@Repository
public interface TermRepository extends CrudRepository<Term, Integer>{

}
