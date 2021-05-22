package com.cg.gradle_dryclean.models;

import javax.persistence.*;

@Entity
@Table(name="address")
public class Address {
	@Id
	@Column(name="door_no", nullable = false)
	private String doorNo;
	
	@Column(name="street", nullable = false)
	private String street;
	
	@Column(name="area", nullable = false)
	private String area;
	
	@Column(name="city", nullable = false)
	private String city;
	
	@Column(name="state", nullable = false)
	private String state;
	
	@Column(name="pincode", nullable = false)
	private int pincode;
	
	public Address() {};
	public Address(String doorNo, String street, String area, String city, String state, int pincode) {
		super();
		this.doorNo = doorNo;
		this.street = street;
		this.area = area;
		this.city = city;
		this.state = state;
		this.pincode = pincode;
	}
	
	public String getDoorNo() {
		return doorNo;
	}

	public void setDoorNo(String doorNo) {
		this.doorNo = doorNo;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	
}
