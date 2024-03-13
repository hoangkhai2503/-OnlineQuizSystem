package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Integer>{

	@Query("from News where enumList.id = 6")
	public List<News> findAllNewsPublicity();
	
	
}
