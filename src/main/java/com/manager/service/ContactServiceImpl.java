package com.manager.service;

import java.util.List;

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
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(int id) {
		try {
			contactRepository.delete(findById(id));
			return true;
		}catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Contact findById(int id) {
		return contactRepository.findById(id).get();
	}

	@Override
	public List<Contact> searchContactByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return contactRepository.searchContactByKeyword(keyword);
	}

}