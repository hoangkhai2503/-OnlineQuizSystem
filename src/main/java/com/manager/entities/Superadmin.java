package com.manager.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.*;
@Entity
@Table(name = "gb_superadmin")
public class Superadmin implements java.io.Serializable{
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    @Column(name = "id_superadmin")
	    private Integer id_superadmin;

	    @Column(name = "username_superadmin")
	    private String username_superadmin;
	    
	    @Column(name = "password_superadmin")
	    private String password_superadmin;

	    @ManyToOne
	    @JoinColumn(name = "role_id_superadmin")
	    private Role role;

	    @ManyToOne
	    @JoinColumn(name = "status_id_superadmin")
	    private EnumList enumlist;


		public Superadmin() {
			super();
		}


		public Superadmin(Integer id_superadmin, String username_superadmin, String password_superadmin, Role role,
				EnumList enumlist) {
			super();
			this.id_superadmin = id_superadmin;
			this.username_superadmin = username_superadmin;
			this.password_superadmin = password_superadmin;
			this.role = role;
			this.enumlist = enumlist;
		}


		public Integer getId_superadmin() {
			return id_superadmin;
		}


		public void setId_superadmin(Integer id_superadmin) {
			this.id_superadmin = id_superadmin;
		}


		public String getUsername_superadmin() {
			return username_superadmin;
		}


		public void setUsername_superadmin(String username_superadmin) {
			this.username_superadmin = username_superadmin;
		}


		public String getPassword_superadmin() {
			return password_superadmin;
		}


		public void setPassword_superadmin(String password_superadmin) {
			this.password_superadmin = password_superadmin;
		}


		public Role getRole() {
			return role;
		}


		public void setRole(Role role) {
			this.role = role;
		}


		public EnumList getEnumlist() {
			return enumlist;
		}


		public void setEnumlist(EnumList enumlist) {
			this.enumlist = enumlist;
		}

		
}
