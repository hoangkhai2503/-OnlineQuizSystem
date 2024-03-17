package com.manager.service;

import com.manager.entities.ClassDetail;

public interface ClassDetailService {
	public Iterable<ClassDetail> findAll();
	
	public boolean save(ClassDetail classDetail);
	
	public int findIdLatest ();
	
}