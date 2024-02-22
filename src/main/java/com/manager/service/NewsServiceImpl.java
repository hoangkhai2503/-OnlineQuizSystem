package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.News;
import com.manager.repository.NewsRepository;
@Service
public class NewsServiceImpl implements NewsService{
	@Autowired
	private NewsRepository newsRepository;
	@Override
	public Iterable<News> findAll() {
		// TODO Auto-generated method stub
		return newsRepository.findAll();
	}

}
