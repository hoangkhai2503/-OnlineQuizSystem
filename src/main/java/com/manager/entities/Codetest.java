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
	    @Column(name = "id_codetest ")
	    private Integer id_codetest ;

	    @Column(name = "name_codetest")
	    private String name_codetest;

	    @ManyToOne
	    @JoinColumn(name = "status_id_codetest")
	    private EnumList enumList;
	    
	    
		public Codetest() {
			super();
		}


		public Codetest(Integer id_codetest, String name_codetest, EnumList enumList) {
			super();
			this.id_codetest = id_codetest;
			this.name_codetest = name_codetest;
			this.enumList = enumList;
		}


		public Integer getId_codetest() {
			return id_codetest;
		}


		public void setId_codetest(Integer id_codetest) {
			this.id_codetest = id_codetest;
		}


		public String getName_codetest() {
			return name_codetest;
		}


		public void setName_codetest(String name_codetest) {
			this.name_codetest = name_codetest;
		}


		public EnumList getEnumList() {
			return enumList;
		}


		public void setEnumList(EnumList enumList) {
			this.enumList = enumList;
		}

		
}
