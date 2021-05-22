package com.cg.gradle_dryclean.models;

import javax.persistence.*;

@Entity
@Table(name="users")
@Inheritance(strategy= InheritanceType.JOINED)
public class User {
	@Id
	@Column(name="user_id")
	private String userId;
	
	@Column(name="password")
	private String password;
	
	public User() {
		
	}
	public User(String userId, String password) {
		super();
		this.userId = userId;
		this.password = password;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
