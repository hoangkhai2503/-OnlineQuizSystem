package com.manager.service;

import com.manager.entities.Contact;

public interface ContactService {
	public Iterable<Contact> findAll();
	
	public boolean save(Contact contact);
}
