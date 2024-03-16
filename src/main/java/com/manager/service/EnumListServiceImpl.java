package com.manager.service;
import java.util.List;
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
		return enumlistRepository.findById1(id);
	}

	@Override
	public List<EnumList> findTypeStatusOfContact() {
		// TODO Auto-generated method stub
		return enumlistRepository.findTypeStatusOfContact();
	}

	@Override
	public List<EnumList> findTypeStatusOfNews() {
		// TODO Auto-generated method stub
		return enumlistRepository.findTypeStatusOfNews();
	}

	@Override
	public List<EnumList> findTypeStatusOfTeacher() {
		// TODO Auto-generated method stub
		return enumlistRepository.findTypeStatusOfTeacher();
	}

	@Override
	public List<EnumList> findTypeStatusOfCodeTest() {
		// TODO Auto-generated method stub
		return enumlistRepository.findTypeStatusOfCodeTest();
	}

	@Override
	public List<EnumList> findTypeStatusOfTerm() {
		// TODO Auto-generated method stub
		return enumlistRepository.findTypeStatusOfTerm();
	}
	@Override
	public EnumList find(int id) {
		// TODO Auto-generated method stub
		return enumlistRepository.findById(id).get();
	}
}
