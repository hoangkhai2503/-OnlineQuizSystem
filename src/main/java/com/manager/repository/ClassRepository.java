package com.manager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities._Class;

@Repository
public interface ClassRepository extends CrudRepository<_Class, Integer>{

	@Query("select max(id_class) from _Class")
	public int findIdLatest();
	
}