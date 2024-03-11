package com.manager.service;

import com.manager.entities.Class;

public interface ClassService {
	public Iterable<Class> findAll();
	public boolean save(Class gbclass);
}
