package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_class")
public class _Class implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_class")
	    private Integer id_class;

	    @Column(name = "name_class")
	    private String name_class;
	    
	    @Column(name = "created_class")
	    private Date created_class;
	    
	    @Column(name = "modified_class")
	    private Date modified_class;
	    
	    @ManyToOne
	    @JoinColumn(name = "form_teacher_id")
	    private Teacher teacher;
	    
	    @ManyToOne
	    @JoinColumn(name = "schoolyear_id_class")
	    private SchoolYear schoolYear;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id_class")
	    private EnumList enumList;

	    
		public _Class() {
			super();
		}


		public _Class(Integer id_class, String name_class, Date created_class, Date modified_class, Teacher teacher, SchoolYear schoolYear,
				EnumList enumList) {
			super();
			this.id_class = id_class;
			this.name_class = name_class;
			this.created_class = created_class;
			this.modified_class = modified_class;
			this.teacher = teacher;
			this.schoolYear = schoolYear;
			this.enumList = enumList;
		}


		public Integer getId_class() {
			return id_class;
		}


		public void setId_class(Integer id_class) {
			this.id_class = id_class;
		}


		public String getName_class() {
			return name_class;
		}


		public void setName_class(String name_class) {
			this.name_class = name_class;
		}


		public Date getCreated_class() {
			return created_class;
		}


		public void setCreated_class(Date created_class) {
			this.created_class = created_class;
		}


		public Date getModified_class() {
			return modified_class;
		}


		public void setModified_class(Date modified_class) {
			this.modified_class = modified_class;
		}


		public Teacher getTeacher() {
			return teacher;
		}


		public void setTeacher(Teacher teacher) {
			this.teacher = teacher;
		}


		public EnumList getEnumList() {
			return enumList;
		}


		public void setEnumList(EnumList enumList) {
			this.enumList = enumList;
		}


		public SchoolYear getSchoolYear() {
			return schoolYear;
		}


		public void setSchoolYear(SchoolYear schoolYear) {
			this.schoolYear = schoolYear;
		}
		
}