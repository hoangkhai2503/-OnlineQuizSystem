package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_superadmin")
public class Superadmin implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "username")
	    private String username;

	    @Column(name = "roleId")
	    private Integer roleId;

	    @Column(name = "statusId")
	    private Integer statusId;


		public Superadmin() {
			super();
		}


		public Superadmin(Integer id, String username, Integer roleId, Integer statusId) {
			super();
			this.id = id;
			this.username = username;
			this.roleId = roleId;
			this.statusId = statusId;
		}


		public Integer getId() {
			return id;
		}


		public void setId(Integer id) {
			this.id = id;
		}


		public String getUsername() {
			return username;
		}


		public void setUsername(String username) {
			this.username = username;
		}


		public Integer getRoleId() {
			return roleId;
		}


		public void setRoleId(Integer roleId) {
			this.roleId = roleId;
		}


		public Integer getStatusId() {
			return statusId;
		}
		
		public void setStatusId(Integer statusId) {
			this.statusId = statusId;
		}
   
}
