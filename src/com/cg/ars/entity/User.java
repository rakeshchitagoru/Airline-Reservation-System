package com.cg.ars.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;

/*****************************************************************
 *@author      : Team 1
 *Package      : com.cg.ars.entity
 *Class Name   : User
 *Description  : This is a POJO class which provides getters and setters for User
 ******************************************************************/


@Entity
@Table(name="users")
public class User {

	@Id
	@Pattern(regexp="[a-z]{8,12}",message="8-12 alphabets in lowercase")
	private String username;
	
	@Pattern(regexp="[A-Za-z]{8,12}",message="8-12 alphabets starting with Uppercase")
	private String password;
	private String role;
	
	@Column(name="mobile_no")
	@Pattern(regexp="[789][0-9]{9}",message="Must be valid phone number eg:(7xxxxxxxxx or 8xxxxxxxxx or 9xxxxxxxxx)")
	private String mobileNo;
	
	/****************************************************************** 
	 * Getter and Setter Methods for User
	 ******************************************************************/
		
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	
}
