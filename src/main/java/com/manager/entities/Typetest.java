package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_typetest")
public class Typetest implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "time")
	    private String time;

	    @Column(name = "quantityQuestion")
	    private Integer quantityQuestion;

	    @Column(name = "scoreFactor")
	    private Integer scoreFactor;
	    
	    @Column(name = "statusId")
	    private Integer statusId;

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

		public String getTime() {
			return time;
		}

		public void setTime(String time) {
			this.time = time;
		}

		public int getQuantityQuestion() {
			return quantityQuestion;
		}

		public void setQuantityQuestion(int quantityQuestion) {
			this.quantityQuestion = quantityQuestion;
		}

		public int getScoreFactor() {
			return scoreFactor;
		}

		public void setScoreFactor(int scoreFactor) {
			this.scoreFactor = scoreFactor;
		}

		public int getStatusId() {
			return statusId;
		}

		public void setStatusId(int statusId) {
			this.statusId = statusId;
		}

		public Typetest(Integer id, String name, String time, int quantityQuestion, int scoreFactor, int statusId) {
			super();
			this.id = id;
			this.name = name;
			this.time = time;
			this.quantityQuestion = quantityQuestion;
			this.scoreFactor = scoreFactor;
			this.statusId = statusId;
		}

		public Typetest() {
			super();
		}
	    
	    
	    
}
