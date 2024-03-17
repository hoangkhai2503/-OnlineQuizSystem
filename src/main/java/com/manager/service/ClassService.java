package com.manager.service;

import com.manager.entities.Answer;
import com.manager.entities._Class;

public interface ClassService {
	public Iterable<_Class> findAll();
	
	public boolean save(_Class _class);
	
	public _Class findId(int id_class);
	
	public int findIdLatest ();
}