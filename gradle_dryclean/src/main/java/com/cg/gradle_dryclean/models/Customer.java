package com.cg.gradle_dryclean.models;

import java.time.LocalDate;

import javax.persistence.*;

import com.cg.gradle_dryclean.models.Address;

@Entity
@Table(name="customers")
@PrimaryKeyJoinColumn(referencedColumnName="user_id")
public class Customer extends User{
	
	@Column(name="name")
  private String name;
	
	@Column(name="email")
  private String email;
	
	@Column(name="contact_no")
  private String contactNo;
	
	@Column(name="dob")
  private LocalDate dob;
public Customer() {
	
}	
public Customer(String userId,String password,String name, String email, String contactNo, LocalDate dob, Address address) {
		super(userId,password);
		this.name = name;
		this.email = email;
		this.contactNo = contactNo;
		this.dob = dob;
		this.address = address;
	}

@OneToOne(cascade = CascadeType.ALL)
@JoinColumn(name="door_no")
  private Address address;


public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getContactNo() {
	return contactNo;
}

public void setContactNo(String contactNo) {
	this.contactNo = contactNo;
}

public LocalDate getDob() {
	return dob;
}

public void setDob(LocalDate dob) {
	this.dob = dob;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}
  
  
}
