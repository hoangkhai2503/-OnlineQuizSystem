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
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "testId")
	    private Integer testId;

	    @Column(name = "studentId")
	    private Integer studentId;

	    @Column(name = "score")
	    private BigDecimal  score;
	    
	    @Column(name = "created")
	    private Date created;
	    
	    @Column(name = "modified")
	    private Date modified;
	    
	    @Column(name = "statusId")
	    private Integer statusId;

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getTestId() {
			return testId;
		}

		public void setTestId(Integer testId) {
			this.testId = testId;
		}

		public Integer getStudentId() {
			return studentId;
		}

		public void setStudentId(Integer studentId) {
			this.studentId = studentId;
		}

		public BigDecimal getScore() {
			return score;
		}

		public void setScore(BigDecimal score) {
			this.score = score;
		}

		public Date getCreated() {
			return created;
		}

		public void setCreated(Date created) {
			this.created = created;
		}

		public Date getModified() {
			return modified;
		}

		public void setModified(Date modified) {
			this.modified = modified;
		}

		public Integer getStatusId() {
			return statusId;
		}

		public void setStatusId(Integer statusId) {
			this.statusId = statusId;
		}

		public TestDetail(Integer id, Integer testId, Integer studentId, BigDecimal score, Date created, Date modified,
				Integer statusId) {
			super();
			this.id = id;
			this.testId = testId;
			this.studentId = studentId;
			this.score = score;
			this.created = created;
			this.modified = modified;
			this.statusId = statusId;
		}

		public TestDetail() {
			super();
		}

	    
}
