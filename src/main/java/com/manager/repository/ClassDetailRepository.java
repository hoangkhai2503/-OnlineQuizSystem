package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.ClassDetail;

@Repository
public interface ClassDetailRepository extends CrudRepository<ClassDetail, Integer>{

}
