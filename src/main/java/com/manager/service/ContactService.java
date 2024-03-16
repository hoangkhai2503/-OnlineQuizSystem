package com.manager.service;

import java.util.List;

import com.manager.entities.Contact;
import com.manager.entities.Teacher;

public interface ContactService {
	public Iterable<Contact> findAll();
	
	public boolean save(Contact contact);
	
	public Contact findById(int id);
	
	public boolean delete(int id);
	
	public List<Contact> searchContactByKeyword(String keyword);
}