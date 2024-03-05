package com.manager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.manager.entities.Contact;
import com.manager.repository.ContactRepository;
@Service
public class ContactServiceImpl implements ContactService{
	@Autowired
	private ContactRepository contactRepository;
	@Override
	public Iterable<Contact> findAll() {
		// TODO Auto-generated method stub
		return contactRepository.findAll();
	}
	@Override
	public boolean save(Contact contact) {
		try {
			contactRepository.save(contact);
			return true;
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

}
