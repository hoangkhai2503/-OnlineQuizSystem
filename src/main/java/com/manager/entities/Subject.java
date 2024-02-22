package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_subject")
public class Subject implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_subject")
	    private Integer id_subject;

	    @Column(name = "name_subject")
	    private String name_subject;

	    @Column(name = "created_subject")
	    private Date created_subject;

	    @Column(name = "modified_subject")
	    private Date modified_subject;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id_subject")
	    private EnumList enumList;
		
		public Subject() {
			super();
		}

		public Subject(Integer id_subject, String name_subject, Date created_subject, Date modified_subject,
				EnumList enumList) {
			super();
			this.id_subject = id_subject;
			this.name_subject = name_subject;
			this.created_subject = created_subject;
			this.modified_subject = modified_subject;
			this.enumList = enumList;
		}

		public Integer getId_subject() {
			return id_subject;
		}

		public void setId_subject(Integer id_subject) {
			this.id_subject = id_subject;
		}

		public String getName_subject() {
			return name_subject;
		}

		public void setName_subject(String name_subject) {
			this.name_subject = name_subject;
		}

		public Date getCreated_subject() {
			return created_subject;
		}

		public void setCreated_subject(Date created_subject) {
			this.created_subject = created_subject;
		}

		public Date getModified_subject() {
			return modified_subject;
		}

		public void setModified_subject(Date modified_subject) {
			this.modified_subject = modified_subject;
		}

		public EnumList getEnumList() {
			return enumList;
		}

		public void setEnumList(EnumList enumList) {
			this.enumList = enumList;
		}

		
}
