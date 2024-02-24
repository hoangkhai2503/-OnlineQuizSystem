package com.manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.manager.entities.Superadmin;

@Repository
public interface SuperAdminRepository extends CrudRepository<Superadmin, Integer>{

}
