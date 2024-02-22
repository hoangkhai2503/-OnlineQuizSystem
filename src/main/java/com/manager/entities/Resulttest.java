package com.manager.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_resulttest")
public class Resulttest implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_resulttest ")
	    private Integer id_resulttest ;

	    @ManyToOne
	    @JoinColumn(name = "test_id_resulttest")
	    private Test test;

	    @Column(name = "score_resulttest")
	    private BigDecimal score_resulttest;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id_resulttest")
	    private EnumList enumlist;   
	    
		public Resulttest() {
			super();
		}

		public Resulttest(Integer id_resulttest, Test test, BigDecimal score_resulttest, EnumList enumlist) {
			super();
			this.id_resulttest = id_resulttest;
			this.test = test;
			this.score_resulttest = score_resulttest;
			this.enumlist = enumlist;
		}

		public Integer getId_resulttest() {
			return id_resulttest;
		}

		public void setId_resulttest(Integer id_resulttest) {
			this.id_resulttest = id_resulttest;
		}

		public Test getTest() {
			return test;
		}

		public void setTest(Test test) {
			this.test = test;
		}

		public BigDecimal getScore_resulttest() {
			return score_resulttest;
		}

		public void setScore_resulttest(BigDecimal score_resulttest) {
			this.score_resulttest = score_resulttest;
		}

		public EnumList getEnumlist() {
			return enumlist;
		}

		public void setEnumlist(EnumList enumlist) {
			this.enumlist = enumlist;
		}

		

}
