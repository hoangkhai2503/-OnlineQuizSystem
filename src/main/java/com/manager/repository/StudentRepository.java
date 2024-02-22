package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

}
