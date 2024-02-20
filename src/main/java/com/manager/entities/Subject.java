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
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "created")
	    private Date created;

	    @Column(name = "modified")
	    private Date modified;
	    
	    @Column(name = "statusId")
	    private Integer statusId;


		public Integer getId() {
			return id;
		}
		
		public void setId(Integer id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
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

		public Subject(Integer id, String name, Date created, Date modified, Integer statusId) {
			super();
			this.id = id;
			this.name = name;
			this.created = created;
			this.modified = modified;
			this.statusId = statusId;
		}

		public Subject() {
			super();
		}

		
}
