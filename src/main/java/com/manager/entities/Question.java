package com.manager.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_question")
public class Question implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_question")
	    private Integer id_question ;

	    @Column(name = "name_question")
	    private String name_question;
	 
	    @ManyToOne
	    @JoinColumn(name = "test_id_question")
	    private Test test;
	    
	    @Column(name = "created_question")
	    private Date created_question;
	    
	    @Column(name = "image_question")
	    private String image_question;
	    
	    @Column(name = "modified_question")
	    private Date modified_question;
	    
		@ManyToOne
	    @JoinColumn(name = "status_id_question")
	    private EnumList enumlist;   
	    
		public Question() {
			super();
		}


		public Question(String name_question, Test test, Date created_question,
				Date modified_question, EnumList enumlist) {
			super();
			this.name_question = name_question;
			this.test = test;
			this.created_question = created_question;
			this.modified_question = modified_question;
			this.enumlist = enumlist;
		}

		public Question(Integer id_question, String name_question, Test test, Date created_question,
				Date modified_question, EnumList enumlist) {
			super();
			this.id_question = id_question;
			this.name_question = name_question;
			this.test = test;
			this.created_question = created_question;
			this.modified_question = modified_question;
			this.enumlist = enumlist;
		}
		
		public Question(Integer id_question, String name_question, Test test, Date created_question,
				String image_question, Date modified_question, EnumList enumlist) {
			super();
			this.id_question = id_question;
			this.name_question = name_question;
			this.test = test;
			this.created_question = created_question;
			this.image_question = image_question;
			this.modified_question = modified_question;
			this.enumlist = enumlist;
		}


		public Integer getId_question() {
			return id_question;
		}


		public void setId_question(Integer id_question) {
			this.id_question = id_question;
		}


		public String getName_question() {
			return name_question;
		}


		public void setName_question(String name_question) {
			this.name_question = name_question;
		}


		public Test getTest() {
			return test;
		}


		public void setTest(Test test) {
			this.test = test;
		}


		public Date getCreated_question() {
			return created_question;
		}


		public void setCreated_question(Date created_question) {
			this.created_question = created_question;
		}


		public Date getModified_question() {
			return modified_question;
		}


		public void setModified_question(Date modified_question) {
			this.modified_question = modified_question;
		}
		

		public String getImage_question() {
			return image_question;
		}


		public void setImage_question(String image_question) {
			this.image_question = image_question;
		}


		public EnumList getEnumlist() {
			return enumlist;
		}


		public void setEnumlist(EnumList enumlist) {
			this.enumlist = enumlist;
		}


}