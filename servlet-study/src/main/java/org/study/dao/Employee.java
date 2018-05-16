package org.study.dao;

import java.util.ArrayList;
import java.util.List;

public class Employee {
	private int id;
	private String name;
	private String password;
	private String email;
	private Country country;
	
	public Employee() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCountry() {
		return country.name();
	}

	public void setCountry(String country) {
		this.country = Country.valueOf(country);
	}
	
//	public String toString() {
//		return "Id : " + getId() + ", Name :" + getName() + ", Country : " + getCountry();
//	}
}
