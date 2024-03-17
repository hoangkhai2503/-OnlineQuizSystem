package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_classdetail")
public class ClassDetail implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_classdetail")
	    private Integer id_classdetail;

	    @ManyToOne
	    @JoinColumn(name = "class_id_classdetail")
	    private _Class gbclass;
	    
	    @ManyToOne
	    @JoinColumn(name = "teacher_id_classdetail")
	    private Teacher teacher;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id_classdetail")
	    private EnumList enumList;
	    
		public ClassDetail() {
			super();
		}

		public ClassDetail(Integer id_classdetail, _Class gbclass, Teacher teacher, EnumList enumList) {
			super();
			this.id_classdetail = id_classdetail;
			this.gbclass = gbclass;
			this.teacher = teacher;
			this.enumList = enumList;
		}

		public Integer getId_classdetail() {
			return id_classdetail;
		}

		public void setId_classdetail(Integer id_classdetail) {
			this.id_classdetail = id_classdetail;
		}

		public _Class getGbclass() {
			return gbclass;
		}

		public void setGbclass(_Class gbclass) {
			this.gbclass = gbclass;
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

		
}