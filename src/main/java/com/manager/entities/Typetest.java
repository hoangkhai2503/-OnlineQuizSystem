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
	    @Column(name = "id_typetest")
	    private Integer id_typetest;

	    @Column(name = "name_typetest")
	    private String name_typetest;

	    @Column(name = "time_typetest")
	    private int time_typetest;

	    @Column(name = "quantityquestion")
	    private Integer quantityQuestion;

	    @Column(name = "scorefactor")
	    private Integer scoreFactor;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id_typetest ")
	    private EnumList enumList;

		public Typetest() {
			super();
		}

		public Typetest(Integer id_typetest, String name_typetest, int time_typetest, Integer quantityQuestion,
				Integer scoreFactor, EnumList enumList) {
			super();
			this.id_typetest = id_typetest;
			this.name_typetest = name_typetest;
			this.time_typetest = time_typetest;
			this.quantityQuestion = quantityQuestion;
			this.scoreFactor = scoreFactor;
			this.enumList = enumList;
		}

		public Integer getId_typetest() {
			return id_typetest;
		}

		public void setId_typetest(Integer id_typetest) {
			this.id_typetest = id_typetest;
		}

		public String getName_typetest() {
			return name_typetest;
		}

		public void setName_typetest(String name_typetest) {
			this.name_typetest = name_typetest;
		}

		public int getTime_typetest() {
			return time_typetest;
		}

		public void setTime_typetest(int time_typetest) {
			this.time_typetest = time_typetest;
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