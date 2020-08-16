package com.in28minutes.database.databasedemo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getRole() {
		return role;
	}

	@Id
	@GeneratedValue
	private Long id;

	public User(String name, String role) {
		this.name = name;
		this.role = role;
	}

	User(){}

	private String name;
	private String role;

}
