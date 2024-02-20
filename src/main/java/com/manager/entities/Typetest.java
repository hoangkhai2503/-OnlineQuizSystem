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

	    @Column(name = "quantity_question")
	    private Integer quantityQuestion;

	    @Column(name = "score_factor")
	    private Integer scoreFactor;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id_typetest")
	    private EnumList enumList;

		public Typetest(Integer id, String name, String time, Integer quantityQuestion, Integer scoreFactor,
				EnumList enumList) {
			super();
			this.id = id;
			this.name = name;
			this.time = time;
			this.quantityQuestion = quantityQuestion;
			this.scoreFactor = scoreFactor;
			this.enumList = enumList;
		}

		public Typetest() {
			super();
		}

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

		public Integer getQuantityQuestion() {
			return quantityQuestion;
		}

		public void setQuantityQuestion(Integer quantityQuestion) {
			this.quantityQuestion = quantityQuestion;
		}

		public Integer getScoreFactor() {
			return scoreFactor;
		}

		public void setScoreFactor(Integer scoreFactor) {
			this.scoreFactor = scoreFactor;
		}

		public EnumList getEnumList() {
			return enumList;
		}

		public void setEnumList(EnumList enumList) {
			this.enumList = enumList;
		}

	    
}
