package com.example.SystemManger.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class UserProfile {
	
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY)
	private long id;
	private String first_name;
	private String last_name;
	private String phone_no;
	private String address;
	
	public UserProfile() {
		
	}
	
	public UserProfile(String first_name, String last_name, String phone_no, String address) {
		super();
		this.first_name = first_name;
		this.last_name = last_name;
		this.phone_no = phone_no;
		this.address = address;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
}
