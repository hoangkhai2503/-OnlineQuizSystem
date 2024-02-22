package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_teacher")
public class Teacher implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_teacher")
	    private Integer id_teacher;

	    @Column(name = "fullname_teacher")
	    private String fullname_teacher;

	    @Column(name = "email_teacher")
	    private String email_teacher;

	    @Column(name = "password_teacher")
	    private String password_teacher;
	    
	    @Column(name = "address_teacher")
	    private String address_teacher;
	    
	    @Column(name = "phone_teacher")
	    private String phone_teacher;
	    
	    @Column(name = "created_teacher")
	    private Date created_teacher;
	    
	    @Column(name = "modified_teacher")
	    private Date modified_teacher;
	    
	    @ManyToOne
	    @JoinColumn(name = "role_id_teacher")
	    private Role role;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id_teacher")
	    private EnumList enumlist;

		public Teacher() {
			super();
		}

		public Teacher(Integer id_teacher, String fullname_teacher, String email_teacher, String password_teacher,
				String address_teacher, String phone_teacher, Date created_teacher, Date modified_teacher, Role role,
				EnumList enumlist) {
			super();
			this.id_teacher = id_teacher;
			this.fullname_teacher = fullname_teacher;
			this.email_teacher = email_teacher;
			this.password_teacher = password_teacher;
			this.address_teacher = address_teacher;
			this.phone_teacher = phone_teacher;
			this.created_teacher = created_teacher;
			this.modified_teacher = modified_teacher;
			this.role = role;
			this.enumlist = enumlist;
		}

		public Integer getId_teacher() {
			return id_teacher;
		}

		public void setId_teacher(Integer id_teacher) {
			this.id_teacher = id_teacher;
		}

		public String getFullname_teacher() {
			return fullname_teacher;
		}

		public void setFullname_teacher(String fullname_teacher) {
			this.fullname_teacher = fullname_teacher;
		}

		public String getEmail_teacher() {
			return email_teacher;
		}

		public void setEmail_teacher(String email_teacher) {
			this.email_teacher = email_teacher;
		}

		public String getPassword_teacher() {
			return password_teacher;
		}

		public void setPassword_teacher(String password_teacher) {
			this.password_teacher = password_teacher;
		}

		public String getAddress_teacher() {
			return address_teacher;
		}

		public void setAddress_teacher(String address_teacher) {
			this.address_teacher = address_teacher;
		}

		public String getPhone_teacher() {
			return phone_teacher;
		}

		public void setPhone_teacher(String phone_teacher) {
			this.phone_teacher = phone_teacher;
		}

		public Date getCreated_teacher() {
			return created_teacher;
		}

		public void setCreated_teacher(Date created_teacher) {
			this.created_teacher = created_teacher;
		}

		public Date getModified_teacher() {
			return modified_teacher;
		}

		public void setModified_teacher(Date modified_teacher) {
			this.modified_teacher = modified_teacher;
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
