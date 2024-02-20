package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_student")
public class Student implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "fullname")
	    private String fullname;

	    @Column(name = "email")
	    private String email;
	    
	    @Column(name = "password")
	    private String password;
	    
	    @Column(name = "address")
	    private String address;
	    
	    @Column(name = "phone")
	    private String phone;

	    @Column(name = "created")
	    private Date created;

	    @Column(name = "modified")
	    private Date modified;
	    
	    @Column(name = "classId")
	    private Integer classId;
	    
	    @Column(name = "roleId")
	    private Integer roleId;
	    
	    @Column(name = "statusId")
	    private Integer statusId;


		
		public Integer getId() {
			return id;
		}



		public void setId(Integer id) {
			this.id = id;
		}



		public String getFullname() {
			return fullname;
		}



		public void setFullname(String fullname) {
			this.fullname = fullname;
		}



		public String getEmail() {
			return email;
		}



		public void setEmail(String email) {
			this.email = email;
		}



		public String getPassword() {
			return password;
		}



		public void setPassword(String password) {
			this.password = password;
		}



		public String getAddress() {
			return address;
		}



		public void setAddress(String address) {
			this.address = address;
		}



		public String getPhone() {
			return phone;
		}



		public void setPhone(String phone) {
			this.phone = phone;
		}



		public Date getCreated() {
			return created;
		}



		public void setCreated(Date created) {
			this.created = created;
		}



		public Date getModified() {
			return modified;
		}



		public void setModified(Date modified) {
			this.modified = modified;
		}



		public Integer getClassId() {
			return classId;
		}



		public void setClassId(Integer classId) {
			this.classId = classId;
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



		public Student(Integer id, String fullname, String email, String password, String address, String phone,
				Date created, Date modified, Integer classId, Integer roleId, Integer statusId) {
			super();
			this.id = id;
			this.fullname = fullname;
			this.email = email;
			this.password = password;
			this.address = address;
			this.phone = phone;
			this.created = created;
			this.modified = modified;
			this.classId = classId;
			this.roleId = roleId;
			this.statusId = statusId;
		}



		public Student() {
			super();
		}

		
}
