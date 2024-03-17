package com.manager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.ClassDetail;

@Repository
public interface ClassDetailRepository extends CrudRepository<ClassDetail, Integer>{

	@Query("select max(id_classdetail) from ClassDetail")
	public int findIdLatest();
	
}