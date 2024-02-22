package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer>{

}
