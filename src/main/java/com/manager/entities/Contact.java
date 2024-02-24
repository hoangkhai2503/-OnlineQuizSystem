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
	    @Column(name = "id_contact ")
	    private Integer id_contact ;

	    @Column(name = "fullname_contact")
	    private String fullname_contact;

	    @Column(name = "phone_contact")
	    private String phone_contact;
	    
	    @Column(name = "address_contact")
	    private String address_contact;
	    
	    @Column(name = "content_contact")
	    private String content_contact;
	    
	    @Column(name = "created_contact")
	    private Date created_contact;
	    
	    @Column(name = "modified_contact")
	    private Date modified_contact;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id_contact")
	    private EnumList enumList;
	    
		public Contact() {
			super();
		}

		public Contact(Integer id_contact, String fullname_contact, String phone_contact, String address_contact,
				String content_contact, Date created_contact, Date modified_contact, EnumList enumList) {
			super();
			this.id_contact = id_contact;
			this.fullname_contact = fullname_contact;
			this.phone_contact = phone_contact;
			this.address_contact = address_contact;
			this.content_contact = content_contact;
			this.created_contact = created_contact;
			this.modified_contact = modified_contact;
			this.enumList = enumList;
		}

		public Integer getId_contact() {
			return id_contact;
		}

		public void setId_contact(Integer id_contact) {
			this.id_contact = id_contact;
		}

		public String getFullname_contact() {
			return fullname_contact;
		}

		public void setFullname_contact(String fullname_contact) {
			this.fullname_contact = fullname_contact;
		}

		public String getPhone_contact() {
			return phone_contact;
		}

		public void setPhone_contact(String phone_contact) {
			this.phone_contact = phone_contact;
		}

		public String getAddress_contact() {
			return address_contact;
		}

		public void setAddress_contact(String address_contact) {
			this.address_contact = address_contact;
		}

		public String getContent_contact() {
			return content_contact;
		}

		public void setContent_contact(String content_contact) {
			this.content_contact = content_contact;
		}

		public Date getCreated_contact() {
			return created_contact;
		}

		public void setCreated_contact(Date created_contact) {
			this.created_contact = created_contact;
		}

		public Date getModified_contact() {
			return modified_contact;
		}

		public void setModified_contact(Date modified_contact) {
			this.modified_contact = modified_contact;
		}

		public EnumList getEnumList() {
			return enumList;
		}

		public void setEnumList(EnumList enumList) {
			this.enumList = enumList;
		}


}
