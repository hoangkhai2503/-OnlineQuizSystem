package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Variable;

@Repository
public interface VariableRepository extends CrudRepository<Variable, Integer>{

}
