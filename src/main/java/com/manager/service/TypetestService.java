package com.manager.service;

import com.manager.entities.Typetest;

public interface TypetestService {
	public Iterable<Typetest> findAll();
	public boolean save(Typetest typetest);

	public Typetest findById(int id);

	public boolean delete(int id);
}
