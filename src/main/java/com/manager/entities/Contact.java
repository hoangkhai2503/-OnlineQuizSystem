package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_contact")
public class Contact implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "fullname")
	    private String fullname;

	    @Column(name = "phone")
	    private String phone;
	    
	    @Column(name = "address")
	    private String address;
	    
	    @Column(name = "content")
	    private String content;
	    
	    @Column(name = "created")
	    private Date created;
	    
	    @Column(name = "modified")
	    private Date modified;
	    
	    @Column(name = "statusId")
	    private Integer statusId;
	    
		public Contact() {
			super();
		}

		public Contact(Integer id, String fullname, String phone, String address, String content, Date created,
				Date modified, Integer statusId) {
			super();
			this.id = id;
			this.fullname = fullname;
			this.phone = phone;
			this.address = address;
			this.content = content;
			this.created = created;
			this.modified = modified;
			this.statusId = statusId;
		}

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

		public String getPhone() {
			return phone;
		}

		public void setPhone(String phone) {
			this.phone = phone;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
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

		public Integer getStatusId() {
			return statusId;
		}

		public void setStatusId(Integer statusId) {
			this.statusId = statusId;
		}

		
}
