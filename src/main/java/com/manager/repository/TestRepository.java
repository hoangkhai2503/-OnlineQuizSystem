package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Test;

@Repository
public interface TestRepository extends CrudRepository<Test, Integer>{

}
