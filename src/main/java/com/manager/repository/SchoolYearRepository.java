package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entities.Answer;
import com.manager.entities.SchoolYear;

@Repository
public interface SchoolYearRepository extends CrudRepository<SchoolYear, Integer>{

	
}