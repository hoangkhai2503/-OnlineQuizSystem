package com.manager.service;

import java.util.List;

import com.manager.entities.EnumList;

public interface EnumListService {
	public Iterable<EnumList> findAll();
	
	public EnumList findById(int id);
	public EnumList find(int id);
	public List<EnumList> findTypeStatusOfContact();
	public List<EnumList> findTypeStatusOfNews();
	public List<EnumList> findTypeStatusOfTeacher();
	public List<EnumList> findTypeStatusOfCodeTest();
	public List<EnumList> findTypeStatusOfTerm();
}
