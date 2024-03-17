package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_term")
public class Term implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_term")
	    private Integer id_term;

	    @Column(name = "name_term")
	    private String name_term;

	    @Column(name = "created_term")
	    private Date created_term;

	    @Column(name = "modified_term")
	    private Date modified_term;

	    @ManyToOne
	    @JoinColumn(name = "schoolyear_id_term")
	    private SchoolYear schoolYear;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id_term")
	    private EnumList enumlist;
	    
		public Term() {
			super();
		}

		public Term(Integer id_term, String name_term, Date created_term, Date modified_term, SchoolYear schoolYear, EnumList enumlist) {
			super();
			this.id_term = id_term;
			this.name_term = name_term;
			this.created_term = created_term;
			this.modified_term = modified_term;
			this.schoolYear = schoolYear;
			this.enumlist = enumlist;
		}

		public Integer getId_term() {
			return id_term;
		}

		public void setId_term(Integer id_term) {
			this.id_term = id_term;
		}

		public String getName_term() {
			return name_term;
		}

		public void setName_term(String name_term) {
			this.name_term = name_term;
		}

		public Date getCreated_term() {
			return created_term;
		}

		public void setCreated_term(Date created_term) {
			this.created_term = created_term;
		}

		public Date getModified_term() {
			return modified_term;
		}

		public void setModified_term(Date modified_term) {
			this.modified_term = modified_term;
		}
		
		public SchoolYear getSchoolYear() {
			return schoolYear;
		}

		public void setSchoolYear(SchoolYear schoolYear) {
			this.schoolYear = schoolYear;
		}

		public EnumList getEnumlist() {
			return enumlist;
		}

		public void setEnumlist(EnumList enumlist) {
			this.enumlist = enumlist;
		}
		
}