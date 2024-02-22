package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Resulttest;

@Repository
public interface ResultTestRepository extends CrudRepository<Resulttest, Integer>{

}
