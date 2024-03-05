package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.EnumList;
import com.manager.repository.EnumListRepository;
@Service
public class EnumListServiceImpl implements EnumListService{
	@Autowired
	private EnumListRepository enumlistRepository;
	@Override
	public Iterable<EnumList> findAll() {
		// TODO Auto-generated method stub
		return enumlistRepository.findAll();
	}
	@Override
	public EnumList findById(int id) {
		// TODO Auto-generated method stub
		return enumlistRepository.findById(id).get();
	}

}
