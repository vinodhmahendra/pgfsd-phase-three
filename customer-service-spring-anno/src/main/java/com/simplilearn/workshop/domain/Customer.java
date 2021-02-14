package com.simplilearn.workshop.domain;

import java.util.UUID;

public class Customer {
	
	private String id;
	private String name;
	private String phone;
	private String email;
	
	public Customer() {
		super(); // invoke a constructor in  Object class
 	}
	
	public Customer(String name,String phone, String email) {
		this.id = UUID.randomUUID().toString();
		this.name = name;
		this.phone = phone;
		this.email = email;
	}
	
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getPhone() {
		return phone;
	}
	public String getEmail() {
		return email;
	}
	
}
