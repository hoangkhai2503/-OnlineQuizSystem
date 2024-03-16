package com.manager.service;

import com.manager.entities.Term;

public interface TermService {
	public Iterable<Term> findAll();
    public boolean save (Term term);

	public Term findById(int id);
}
