package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Codetest;

@Repository
public interface CodeTestRepository extends CrudRepository<Codetest, Integer>{

}
