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
	    @Column(name = "id_role")
	    private Integer id_role;

	    @Column(name = "name_role")
	    private String name_role;

	    @ManyToOne
	    @JoinColumn(name = "status_id_role")
	    private EnumList enumList;
	    
		public Role() {
			super();
		}

		public Role(Integer id_role, String name_role, EnumList enumList) {
			super();
			this.id_role = id_role;
			this.name_role = name_role;
			this.enumList = enumList;
		}

		public Integer getId_role() {
			return id_role;
		}

		public void setId_role(Integer id_role) {
			this.id_role = id_role;
		}

		public String getName_role() {
			return name_role;
		}

		public void setName_role(String name_role) {
			this.name_role = name_role;
		}

		public EnumList getEnumList() {
			return enumList;
		}

		public void setEnumList(EnumList enumList) {
			this.enumList = enumList;
		}

}
