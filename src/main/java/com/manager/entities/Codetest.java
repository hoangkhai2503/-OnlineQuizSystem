package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_codetest")
public class Codetest implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "statusId")
	    private Integer statusId;
	    
	    
		public Codetest() {
			super();
		}


		public Codetest(Integer id, String name, Integer statusId) {
			super();
			this.id = id;
			this.name = name;
			this.statusId = statusId;
		}


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


		public Integer getStatusId() {
			return statusId;
		}


		public void setStatusId(Integer statusId) {
			this.statusId = statusId;
		}

}
