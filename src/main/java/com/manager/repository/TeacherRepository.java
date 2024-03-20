package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entities.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer>{

	@Query("from Teacher where enumlist.id = 4")
	public List<Teacher> findAllTeacherActive();
	
	@Query("from Teacher where enumlist.id = 5")
	public List<Teacher> findAllTeacherInactive();
	
	@Query("from Teacher where email_teacher = :email_teacher")
	public Teacher findTeacherByEmail(@Param("email_teacher") String email_teacher);
}
