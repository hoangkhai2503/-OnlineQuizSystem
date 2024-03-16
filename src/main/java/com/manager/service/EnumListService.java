package com.manager.service;

import com.manager.entities.EnumList;

import java.util.List;
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
