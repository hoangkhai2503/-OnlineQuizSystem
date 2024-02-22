package com.service;

import java.util.List;

import com.dtos.DemoDTO;



public interface DemoService {

	public boolean save(DemoDTO demoDTO);
	
	public boolean login(DemoDTO demoDTO);
	
	public boolean login(String username, String password);
	
	public List<DemoDTO> findAll();
	
	public List<DemoDTO> findByKeyword(String keyword);
	
	public DemoDTO find(int id);
	
}
