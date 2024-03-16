package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_answer")
public class Answer implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_answer")
	    private Integer id_answer;

	    @Column(name = "name_answer")
	    private String name_answer;

	    @Column(name = "created_answer")
	    private Date created_answer;
	    
	    @Column(name = "modified_answer")
	    private Date modified_answer;
	    
	    @ManyToOne
	    @JoinColumn(name = "question_id_answer")
	    private Question question;

	    @ManyToOne
	    @JoinColumn(name = "status_id_answer")
	    private EnumList enumlist;
	    
		public Answer() {
			super();
		}
		public Answer(String name_answer, Date created_answer, Date modified_answer, Question question,
				EnumList enumlist) {
			super();
			this.name_answer = name_answer;
			this.created_answer = created_answer;
			this.modified_answer = modified_answer;
			this.question = question;
			this.enumlist = enumlist;
		}
		
		public Answer(Integer id_answer, String name_answer, Date created_answer, Date modified_answer,
				Question question, EnumList enumlist) {
			super();
			this.id_answer = id_answer;
			this.name_answer = name_answer;
			this.created_answer = created_answer;
			this.modified_answer = modified_answer;
			this.question = question;
			this.enumlist = enumlist;
		}

		public Integer getId_answer() {
			return id_answer;
		}

		public void setId_answer(Integer id_answer) {
			this.id_answer = id_answer;
		}

		public String getName_answer() {
			return name_answer;
		}

		public void setName_answer(String name_answer) {
			this.name_answer = name_answer;
		}

		public Date getCreated_answer() {
			return created_answer;
		}

		public void setCreated_answer(Date created_answer) {
			this.created_answer = created_answer;
		}

		public Date getModified_answer() {
			return modified_answer;
		}

		public void setModified_answer(Date modified_answer) {
			this.modified_answer = modified_answer;
		}

		public Question getQuestion() {
			return question;
		}

		public void setQuestion(Question question) {
			this.question = question;
		}

		public EnumList getEnumlist() {
			return enumlist;
		}

		public void setEnumlist(EnumList enumlist) {
			this.enumlist = enumlist;
		}
		
	
		
}
