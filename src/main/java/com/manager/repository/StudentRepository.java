package com.manager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entities.Student;

@Repository
public interface StudentRepository extends CrudRepository<Student, Integer>{

	@Query("from Student where email_student = :email_student")
	public Student findByEmailStudent(@Param("email_student") String email_student);
	
}
