package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_news")
public class News implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id")
	    private Integer id;

	    @Column(name = "title")
	    private String title;

	    @Column(name = "content")
	    private String content;
	    
	    @Column(name = "created")
	    private Date created;
	    
	    @Column(name = "modified")
	    private Date modified;
	    
	    @Column(name = "author")
	    private Integer author;
	    
	    @Column(name = "statusId")
	    private Integer statusId;
	    
		public News() {
			super();
		}

		public News(Integer id, String title, String content, Date created, Date modified, Integer author,
				Integer statusId) {
			super();
			this.id = id;
			this.title = title;
			this.content = content;
			this.created = created;
			this.modified = modified;
			this.author = author;
			this.statusId = statusId;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getContent() {
			return content;
		}

		public void setContent(String content) {
			this.content = content;
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

		public Integer getAuthor() {
			return author;
		}

		public void setAuthor(Integer author) {
			this.author = author;
		}

		public Integer getStatusId() {
			return statusId;
		}

		public void setStatusId(Integer statusId) {
			this.statusId = statusId;
		}

		
		
}
