package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.News;

@Repository
public interface NewsRepository extends CrudRepository<News, Integer>{

}
