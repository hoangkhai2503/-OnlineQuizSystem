package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Contact;
import com.manager.entities.EnumList;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer>{
}
