package com.manager.service;

import com.manager.entities.Codetest;

public interface CodeTestService {
	public Iterable<Codetest> findAll();
	public boolean save(Codetest codeTest);

	public Codetest findById( int id);
}
