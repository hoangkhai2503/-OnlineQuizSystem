package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Subject;

@Repository
public interface SubjectRepository extends CrudRepository<Subject, Integer>{

}
