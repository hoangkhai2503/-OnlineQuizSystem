package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Typetest;

@Repository
public interface TypeTestRepository extends CrudRepository<Typetest, Integer>{

}
