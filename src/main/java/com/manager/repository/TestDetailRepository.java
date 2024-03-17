package com.manager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entities.TestDetail;

@Repository
public interface TestDetailRepository extends CrudRepository<TestDetail, Integer>{

	@Query("select max(id_testdetail) from TestDetail")
	public int findIdLatest();
	
	@Query("from TestDetail where student.id_student = :idStudent and test.id_test = :idTest")
	public TestDetail findByIdStudentAndIdTest(@Param("idStudent") int idStudent, @Param("idTest") int idTest);
	
}