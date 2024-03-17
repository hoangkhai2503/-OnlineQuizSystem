package com.manager.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_testdetail")
public class TestDetail implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_testdetail")
	    private Integer id_testdetail;

	    @ManyToOne
	    @JoinColumn(name = "test_id_testdetail")
	    private Test test;

	    @ManyToOne
	    @JoinColumn(name = "student_id_testdetail")
	    private Student student;

	    @Column(name = "score_testdetail")
	    private double  score_testdetail;
	    
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    @Column(name = "created_testdetail")
	    private Date created_testdetail;
	    
	    @DateTimeFormat(pattern = "dd/MM/yyyy")
	    @Column(name = "modified_testdetail")
	    private Date modified_testdetail;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id_testdetail")
	    private EnumList enumList;

		public TestDetail() {
			super();
		}

		public TestDetail(Integer id_testdetail, Test test, Student student, double score_testdetail,
				Date created_testdetail, Date modified_testdetail, EnumList enumList) {
			super();
			this.id_testdetail = id_testdetail;
			this.test = test;
			this.student = student;
			this.score_testdetail = score_testdetail;
			this.created_testdetail = created_testdetail;
			this.modified_testdetail = modified_testdetail;
			this.enumList = enumList;
		}

		public Integer getId_testdetail() {
			return id_testdetail;
		}

		public void setId_testdetail(Integer id_testdetail) {
			this.id_testdetail = id_testdetail;
		}

		public Test getTest() {
			return test;
		}

		public void setTest(Test test) {
			this.test = test;
		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public double getScore_testdetail() {
			return score_testdetail;
		}

		public void setScore_testdetail(double score_testdetail) {
			this.score_testdetail = score_testdetail;
		}

		public Date getCreated_testdetail() {
			return created_testdetail;
		}

		public void setCreated_testdetail(Date created_testdetail) {
			this.created_testdetail = created_testdetail;
		}

		public Date getModified_testdetail() {
			return modified_testdetail;
		}

		public void setModified_testdetail(Date modified_testdetail) {
			this.modified_testdetail = modified_testdetail;
		}

		public EnumList getEnumList() {
			return enumList;
		}

		public void setEnumList(EnumList enumList) {
			this.enumList = enumList;
		}
		
		
	  
}