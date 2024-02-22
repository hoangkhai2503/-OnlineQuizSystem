package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_variable")
public class Variable implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_variable")
	    private Integer id_variable;

	    @Column(name = "name_variable")
	    private String name_variable;

	    @Column(name = "image_variable")
	    private String image_variable;

	    @Column(name = "code_variable")
	    private String code_variable;

		
		public Variable() {
			super();
		}


		public Variable(Integer id_variable, String name_variable, String image_variable, String code_variable) {
			super();
			this.id_variable = id_variable;
			this.name_variable = name_variable;
			this.image_variable = image_variable;
			this.code_variable = code_variable;
		}


		public Integer getId_variable() {
			return id_variable;
		}


		public void setId_variable(Integer id_variable) {
			this.id_variable = id_variable;
		}


		public String getName_variable() {
			return name_variable;
		}


		public void setName_variable(String name_variable) {
			this.name_variable = name_variable;
		}


		public String getImage_variable() {
			return image_variable;
		}


		public void setImage_variable(String image_variable) {
			this.image_variable = image_variable;
		}


		public String getCode_variable() {
			return code_variable;
		}
		
		public void setCode_variable(String code_variable) {
			this.code_variable = code_variable;
		}
   
}
