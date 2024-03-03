package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer>{

	@Query("from Teacher where enumlist.id = 4")
	public List<Teacher> findAllTeacherActive();
	
	@Query("from Teacher where enumlist.id = 5")
	public List<Teacher> findAllTeacherInactive();
}
