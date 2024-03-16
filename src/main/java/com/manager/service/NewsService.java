package com.manager.service;

import java.util.List;

import com.manager.entities.News;

public interface NewsService {
	public Iterable<News> findAll();
	
	public boolean save(News news);
	
	public News findById(int id);
	
	public boolean delete(int id);
	
	public List<News> findAllNewsPublicity();
}