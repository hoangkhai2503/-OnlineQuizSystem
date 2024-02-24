package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Term;
import com.manager.repository.TermRepository;
@Service
public class TermServiceImpl implements TermService{
	@Autowired
	private TermRepository termRepository;
	@Override
	public Iterable<Term> findAll() {
		// TODO Auto-generated method stub
		return termRepository.findAll();
	}

}
