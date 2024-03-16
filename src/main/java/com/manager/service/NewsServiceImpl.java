package com.manager.service;

import java.util.List;

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
	@Override
	public boolean save(News news) {
		try {
			newsRepository.save(news);
			return true;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public News findById(int id) {
		return newsRepository.findById(id).get();
	}
	@Override
	public boolean delete(int id) {
		try {
			newsRepository.delete(findById(id));
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	@Override
	public List<News> findAllNewsPublicity() {
		// TODO Auto-generated method stub
		return newsRepository.findAllNewsPublicity();
	}

}