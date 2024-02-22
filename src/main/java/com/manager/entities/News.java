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
	    @Column(name = "id_news")
	    private Integer id_news;

	    @Column(name = "title_news")
	    private String title_news;

	    @Column(name = "content_news")
	    private String content_news;
	    
	    @Column(name = "created_news")
	    private Date created_news;
	    
	    @Column(name = "modified_news")
	    private Date modified_news;
	    
	    @ManyToOne
	    @JoinColumn(name = "status_id_news")
	    private EnumList enumList;
	    
		public News() {
			super();
		}

		
		public News(Integer id_news, String title_news, String content_news, Date created_news, Date modified_news,
				EnumList enumList) {
			super();
			this.id_news = id_news;
			this.title_news = title_news;
			this.content_news = content_news;
			this.created_news = created_news;
			this.modified_news = modified_news;
			this.enumList = enumList;
		}


		public Integer getId_news() {
			return id_news;
		}


		public void setId_news(Integer id_news) {
			this.id_news = id_news;
		}


		public String getTitle_news() {
			return title_news;
		}


		public void setTitle_news(String title_news) {
			this.title_news = title_news;
		}


		public String getContent_news() {
			return content_news;
		}


		public void setContent_news(String content_news) {
			this.content_news = content_news;
		}


		public Date getCreated_news() {
			return created_news;
		}


		public void setCreated_news(Date created_news) {
			this.created_news = created_news;
		}


		public Date getModified_news() {
			return modified_news;
		}


		public void setModified_news(Date modified_news) {
			this.modified_news = modified_news;
		}


		public EnumList getEnumList() {
			return enumList;
		}


		public void setEnumList(EnumList enumList) {
			this.enumList = enumList;
		}

}
