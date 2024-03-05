package com.manager.service;

import java.util.List;

import com.manager.entities.News;

public interface NewsService {
	public Iterable<News> findAll();
	
	public List<News> findAllNewsPublicity();
}
