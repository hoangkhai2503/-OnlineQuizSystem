package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.manager.entities.Teacher;

@Repository
public interface TeacherRepository extends CrudRepository<Teacher, Integer>{

	@Query("from Teacher where enumlist.id = 4")
	public List<Teacher> findAllTeacherActive();
	
	@Query("from Teacher where enumlist.id = 5")
	public List<Teacher> findAllTeacherInactive();
	
	@Query("from Teacher where fullname_teacher like %:keyword% or phone_teacher like %:keyword% or email_teacher like %:keyword%")
	public List<Teacher> searchTeacherByKeyword(@Param("keyword") String keyword);
}