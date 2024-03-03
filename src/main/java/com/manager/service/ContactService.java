package com.manager.service;

import com.manager.entities.Contact;

public interface ContactService {
	public Iterable<Contact> findAll();
	
	public boolean save(Contact contact);
	
	public Contact findById(int id);
	
	public boolean delete(int id);
}
