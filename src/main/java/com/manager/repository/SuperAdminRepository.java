package com.manager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.manager.entities.Superadmin;

@Repository
public interface SuperAdminRepository extends CrudRepository<Superadmin, Integer>{

	@Query("from Superadmin where username_superadmin = :username_superadmin and password_superadmin = :password_superadmin")
	public Superadmin loginAdmin(@Param("username_superadmin") String username_superadmin, @Param("password_superadmin") String password_superadmin);

	@Query("from Superadmin where username_superadmin = :username_superadmin")
	public Superadmin findByUsernameAdmin(@Param("username_superadmin") String username_superadmin);
	
}
