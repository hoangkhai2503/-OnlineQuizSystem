package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Result;

@Repository
public interface ResultRepository extends CrudRepository<Result, Integer>{

}
