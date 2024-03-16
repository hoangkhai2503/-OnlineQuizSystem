package com.manager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entities.Contact;
import com.manager.entities.EnumList;
import com.manager.entities.Teacher;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Integer>{
	
	@Query("from Contact where fullname_contact like %:keyword% or phone_contact like %:keyword% or address_contact like %:keyword%")
	public List<Contact> searchContactByKeyword(@Param("keyword") String keyword);
	
}