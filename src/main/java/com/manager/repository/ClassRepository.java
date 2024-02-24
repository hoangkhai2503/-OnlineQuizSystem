package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Class;

@Repository
public interface ClassRepository extends CrudRepository<Class, Integer>{

}
