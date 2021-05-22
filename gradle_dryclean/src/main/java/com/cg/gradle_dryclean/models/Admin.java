package com.cg.gradle_dryclean.models;

import javax.persistence.*;

@Entity
@Table(name="admins")
@PrimaryKeyJoinColumn(referencedColumnName="user_id")
public class Admin extends User {
	public Admin(String userId, String password) {
		super(userId, password);
	}
	
}


