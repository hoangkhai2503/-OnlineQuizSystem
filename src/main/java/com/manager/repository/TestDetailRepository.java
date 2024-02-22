package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.TestDetail;

@Repository
public interface TestDetailRepository extends CrudRepository<TestDetail, Integer>{

}
