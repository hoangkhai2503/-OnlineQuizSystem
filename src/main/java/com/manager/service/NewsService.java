package com.manager.service;

import com.manager.entities.News;

public interface NewsService {
	public Iterable<News> findAll();
}
