package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;

@Entity
@Table(name = "gb_test")
public class Test implements java.io.Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_test")
	private Integer id_test;

	@Column(name = "name_test")
	private String name_test;

	@ManyToOne
	@JoinColumn(name = "class_id_test")
	private _Class gbclass;

	@ManyToOne
	@JoinColumn(name = "subject_id_test")
	private Subject subject;

	@ManyToOne
	@JoinColumn(name = "term_id_test")
	private Term term;

	@ManyToOne
	@JoinColumn(name = "typetest_id_test")
	private Typetest typetest;

	@ManyToOne
	@JoinColumn(name = "codetest_id_test")
	private Codetest codetest;
	
	@Column(name = "starttime_test")
	// @DateTimeFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private String starttime_test;

	@Column(name = "ongoing_test")
	private String ongoing_test;

	@Column(name = "endtime_test")
	private String endtime_test;

	@Column(name = "created_test")
	private Date created_test;

	@Column(name = "modified_test")
	private Date modified_test;

	@ManyToOne
	@JoinColumn(name = "status_id_test")
	private EnumList enumlist;

	public Test() {
		super();
	}

	public Test(Integer id_test, String name_test, _Class gbclass, Subject subject, Term term, Typetest typetest,
			Codetest codetest, String starttime_test, String ongoing_test, String endtime_test, Date created_test,
			Date modified_test, EnumList enumlist) {
		super();
		this.id_test = id_test;
		this.name_test = name_test;
		this.gbclass = gbclass;
		this.subject = subject;
		this.term = term;
		this.typetest = typetest;
		this.codetest = codetest;
		this.starttime_test = starttime_test;
		this.ongoing_test = ongoing_test;
		this.endtime_test = endtime_test;
		this.created_test = created_test;
		this.modified_test = modified_test;
		this.enumlist = enumlist;
	}

	public Integer getId_test() {
		return id_test;
	}

	public void setId_test(Integer id_test) {
		this.id_test = id_test;
	}

	public String getName_test() {
		return name_test;
	}

	public void setName_test(String name_test) {
		this.name_test = name_test;
	}

	public _Class getGbclass() {
		return gbclass;
	}

	public void setGbclass(_Class gbclass) {
		this.gbclass = gbclass;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Term getTerm() {
		return term;
	}

	public void setTerm(Term term) {
		this.term = term;
	}

	public Typetest getTypetest() {
		return typetest;
	}

	public void setTypetest(Typetest typetest) {
		this.typetest = typetest;
	}

	public Codetest getCodetest() {
		return codetest;
	}

	public void setCodetest(Codetest codetest) {
		this.codetest = codetest;
	}

	public String getStarttime_test() {
		return starttime_test;
	}

	public void setStarttime_test(String starttime_test) {
		this.starttime_test = starttime_test;
	}

	public String getOngoing_test() {
		return ongoing_test;
	}

	public void setOngoing_test(String ongoing_test) {
		this.ongoing_test = ongoing_test;
	}

	public String getEndtime_test() {
		return endtime_test;
	}

	public void setEndtime_test(String endtime_test) {
		this.endtime_test = endtime_test;
	}

	public Date getCreated_test() {
		return created_test;
	}

	public void setCreated_test(Date created_test) {
		this.created_test = created_test;
	}

	public Date getModified_test() {
		return modified_test;
	}

	public void setModified_test(Date modified_test) {
		this.modified_test = modified_test;
	}

	public EnumList getEnumlist() {
		return enumlist;
	}

	public void setEnumlist(EnumList enumlist) {
		this.enumlist = enumlist;
	}



}