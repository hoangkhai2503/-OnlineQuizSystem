package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer>{

}
