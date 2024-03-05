package com.manager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entities.Variable;

@Repository
public interface VariableRepository extends CrudRepository<Variable, Integer>{
  @Query("from Variable where code_variable =:code_variable")
  public Variable findByCode_variable(@Param("code_variable")String code_variable);
  
}
