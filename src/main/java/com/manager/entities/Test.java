package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_typetest")
public class Test implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "name")
	    private String name;

	    @Column(name = "classId")
	    private Integer classId;

	    @Column(name = "subjectId")
	    private Integer subjectId;
	    
	    @Column(name = "termId")
	    private Integer termId;
	    
	    @Column(name = "typeTestId")
	    private Integer typeTestId;
	    
	    @Column(name = "codeTestId")
	    private Integer codeTestId;
	    
	    @Column(name = "startTime")
	    private Date startTime;
	    
	    @Column(name = "onGoing")
	    private Date onGoing;
	    
	    @Column(name = "endTime")
	    private Date endTime;
	    
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

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public Integer getClassId() {
			return classId;
		}

		public void setClassId(Integer classId) {
			this.classId = classId;
		}

		public Integer getSubjectId() {
			return subjectId;
		}

		public void setSubjectId(Integer subjectId) {
			this.subjectId = subjectId;
		}

		public Integer getTermId() {
			return termId;
		}

		public void setTermId(Integer termId) {
			this.termId = termId;
		}

		public Integer getTypeTestId() {
			return typeTestId;
		}

		public void setTypeTestId(Integer typeTestId) {
			this.typeTestId = typeTestId;
		}

		public Integer getCodeTestId() {
			return codeTestId;
		}

		public void setCodeTestId(Integer codeTestId) {
			this.codeTestId = codeTestId;
		}

		public Date getStartTime() {
			return startTime;
		}

		public void setStartTime(Date startTime) {
			this.startTime = startTime;
		}

		public Date getOnGoing() {
			return onGoing;
		}

		public void setOnGoing(Date onGoing) {
			this.onGoing = onGoing;
		}

		public Date getEndTime() {
			return endTime;
		}

		public void setEndTime(Date endTime) {
			this.endTime = endTime;
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

		public Test(Integer id, String name, Integer classId, Integer subjectId, Integer termId, Integer typeTestId,
				Integer codeTestId, Date startTime, Date onGoing, Date endTime, Date created, Date modified,
				Integer statusId) {
			super();
			this.id = id;
			this.name = name;
			this.classId = classId;
			this.subjectId = subjectId;
			this.termId = termId;
			this.typeTestId = typeTestId;
			this.codeTestId = codeTestId;
			this.startTime = startTime;
			this.onGoing = onGoing;
			this.endTime = endTime;
			this.created = created;
			this.modified = modified;
			this.statusId = statusId;
		}

		public Test() {
			super();
		}

	    
	    
	    
	    
}
