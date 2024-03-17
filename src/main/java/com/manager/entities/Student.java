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
	    @Column(name = "id_student")
	    private Integer id_student;

	    @Column(name = "fullname_student")
	    private String fullname_student;

	    @Column(name = "email_student")
	    private String email_student;
	    
	    @Column(name = "password_student")
	    private String password_student;
	    
	    @Column(name = "address_student")
	    private String address_student;
	    
	    @Column(name = "phone_student")
	    private String phone_student;

	    @Column(name = "created_student")
	    private Date created_student;

	    @Column(name = "modified_student")
	    private Date modified_student;
	    
	    @ManyToOne
	    @JoinColumn(name = "class_id_student")
	    private _Class gbclass;
	    
	    @ManyToOne
	    @JoinColumn(name = "role_id_student")
	    private Role role;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id_student")
	    private EnumList enumlist;

		public Student() {
			super();
		}

		public Student(Integer id_student, String fullname_student, String email_student, String password_student,
				String address_student, String phone_student, Date created_student, Date modified_student,
				_Class gbclass, Role role, EnumList enumlist) {
			super();
			this.id_student = id_student;
			this.fullname_student = fullname_student;
			this.email_student = email_student;
			this.password_student = password_student;
			this.address_student = address_student;
			this.phone_student = phone_student;
			this.created_student = created_student;
			this.modified_student = modified_student;
			this.gbclass = gbclass;
			this.role = role;
			this.enumlist = enumlist;
		}
		
		public Student(String fullname_student, String email_student, String password_student,
				String address_student, String phone_student, Date created_student, Date modified_student,
				_Class gbclass, Role role, EnumList enumlist) {
			super();
			this.fullname_student = fullname_student;
			this.email_student = email_student;
			this.password_student = password_student;
			this.address_student = address_student;
			this.phone_student = phone_student;
			this.created_student = created_student;
			this.modified_student = modified_student;
			this.gbclass = gbclass;
			this.role = role;
			this.enumlist = enumlist;
		}



		public Integer getId_student() {
			return id_student;
		}

		public void setId_student(Integer id_student) {
			this.id_student = id_student;
		}

		public String getFullname_student() {
			return fullname_student;
		}

		public void setFullname_student(String fullname_student) {
			this.fullname_student = fullname_student;
		}

		public String getEmail_student() {
			return email_student;
		}

		public void setEmail_student(String email_student) {
			this.email_student = email_student;
		}

		public String getPassword_student() {
			return password_student;
		}

		public void setPassword_student(String password_student) {
			this.password_student = password_student;
		}

		public String getAddress_student() {
			return address_student;
		}

		public void setAddress_student(String address_student) {
			this.address_student = address_student;
		}

		public String getPhone_student() {
			return phone_student;
		}

		public void setPhone_student(String phone_student) {
			this.phone_student = phone_student;
		}

		public Date getCreated_student() {
			return created_student;
		}

		public void setCreated_student(Date created_student) {
			this.created_student = created_student;
		}

		public Date getModified_student() {
			return modified_student;
		}

		public void setModified_student(Date modified_student) {
			this.modified_student = modified_student;
		}

		public _Class getGbclass() {
			return gbclass;
		}

		public void setGbclass(_Class gbclass) {
			this.gbclass = gbclass;
		}

		public Role getRole() {
			return role;
		}

		public void setRole(Role role) {
			this.role = role;
		}

		public EnumList getEnumlist() {
			return enumlist;
		}

		public void setEnumlist(EnumList enumlist) {
			this.enumlist = enumlist;
		}
		
}