package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_schoolyear")
public class SchoolYear implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_schoolyear")
	    private Integer id_schoolyear;

	    @Column(name = "name_schoolyear")
	    private String name_schoolyear;

	    @ManyToOne
	    @JoinColumn(name = "status_id_schoolyear")
	    private EnumList enumlist;
	    
		public SchoolYear() {
			super();
		}

		public SchoolYear(Integer id_schoolyear, String name_schoolyear, EnumList enumlist) {
			super();
			this.id_schoolyear = id_schoolyear;
			this.name_schoolyear = name_schoolyear;
			this.enumlist = enumlist;
		}

		public Integer getId_schoolyear() {
			return id_schoolyear;
		}

		public void setId_schoolyear(Integer id_schoolyear) {
			this.id_schoolyear = id_schoolyear;
		}

		public String getName_schoolyear() {
			return name_schoolyear;
		}

		public void setName_schoolyear(String name_schoolyear) {
			this.name_schoolyear = name_schoolyear;
		}

		public EnumList getEnumlist() {
			return enumlist;
		}

		public void setEnumlist(EnumList enumlist) {
			this.enumlist = enumlist;
		}
	    
		
}