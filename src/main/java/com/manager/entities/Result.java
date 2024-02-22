package com.manager.entities;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_result")
public class Result implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_result ")
	    private Integer id_result ;

	    @ManyToOne
	    @JoinColumn(name = "student_id_result")
	    private Student student;
	    
	    @ManyToOne
	    @JoinColumn(name = "subject_id_result")
	    private Subject subject;

	    @Column(name = "title_result")
	    private String title_result;
	    
	    @Column(name = "totalscore_result")
	    private BigDecimal totalscore_result;
	    
	    @Column(name = "created_result")
	    private Date created_result;
	    
	    @Column(name = "modified_result")
	    private Date modified_result;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id_result")
	    private EnumList enumlist;   
	    
		public Result() {
			super();
		}

		public Result(Integer id_result, Student student, Subject subject, String title_result,
				BigDecimal totalscore_result, Date created_result, Date modified_result, EnumList enumlist) {
			super();
			this.id_result = id_result;
			this.student = student;
			this.subject = subject;
			this.title_result = title_result;
			this.totalscore_result = totalscore_result;
			this.created_result = created_result;
			this.modified_result = modified_result;
			this.enumlist = enumlist;
		}

		public Integer getId_result() {
			return id_result;
		}

		public void setId_result(Integer id_result) {
			this.id_result = id_result;
		}

		public Student getStudent() {
			return student;
		}

		public void setStudent(Student student) {
			this.student = student;
		}

		public Subject getSubject() {
			return subject;
		}

		public void setSubject(Subject subject) {
			this.subject = subject;
		}

		public String getTitle_result() {
			return title_result;
		}

		public void setTitle_result(String title_result) {
			this.title_result = title_result;
		}

		public BigDecimal getTotalscore_result() {
			return totalscore_result;
		}

		public void setTotalscore_result(BigDecimal totalscore_result) {
			this.totalscore_result = totalscore_result;
		}

		public Date getCreated_result() {
			return created_result;
		}

		public void setCreated_result(Date created_result) {
			this.created_result = created_result;
		}

		public Date getModified_result() {
			return modified_result;
		}

		public void setModified_result(Date modified_result) {
			this.modified_result = modified_result;
		}

		public EnumList getEnumlist() {
			return enumlist;
		}

		public void setEnumlist(EnumList enumlist) {
			this.enumlist = enumlist;
		}

		
}
