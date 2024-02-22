package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_status")
public class EnumList implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "status")
	    private String status;

	    @Column(name = "typestatus")
	    private String typestatus;

		public EnumList(Integer id, String name, String status, String typestatus) {
			super();
			this.id = id;
			this.name = name;
			this.status = status;
			this.typestatus = typestatus;

		}

		public EnumList() {
			super();
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

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public String getTypestatus() {
			return typestatus;
		}

		public void setTypestatus(String typestatus) {
			this.typestatus = typestatus;
		}


		
}
