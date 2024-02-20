package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_role")
public class Role implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "statusId")
	    private String statusId;
	    
		public Role() {
			super();
		}

		public Role(Integer id, String name, String statusId) {
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

		public String getStatusId() {
			return statusId;
		}

		public void setStatusId(String statusId) {
			this.statusId = statusId;
		}
		// endregion
		
}
