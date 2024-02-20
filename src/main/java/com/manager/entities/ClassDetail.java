package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_classdetail")
public class ClassDetail implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "classId")
	    private Integer classId;

	    @Column(name = "studentId")
	    private Integer studentId;
	    
	    @Column(name = "teacherId")
	    private Integer teacherId;
	    
	    @Column(name = "subjectId")
	    private Integer subjectId;
	    
	    @Column(name = "statusId")
	    private Integer statusId;
	    
		public ClassDetail() {
			super();
		}

		public ClassDetail(Integer id, Integer classId, Integer studentId, Integer teacherId, Integer statusId) {
			super();
			this.id = id;
			this.classId = classId;
			this.studentId = studentId;
			this.teacherId = teacherId;
			this.statusId = statusId;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public Integer getClassId() {
			return classId;
		}

		public void setClassId(Integer classId) {
			this.classId = classId;
		}

		public Integer getStudentId() {
			return studentId;
		}

		public void setStudentId(Integer studentId) {
			this.studentId = studentId;
		}

		public Integer getTeacherId() {
			return teacherId;
		}

		public void setTeacherId(Integer teacherId) {
			this.teacherId = teacherId;
		}

		public Integer getStatusId() {
			return statusId;
		}

		public void setStatusId(Integer statusId) {
			this.statusId = statusId;
		}

}
