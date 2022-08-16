package com.qa.jdbc.domain;

public class Customer {
	private int id;
	private String firstName;
	private String lastName;
	private String email;
	
	
	//for creating
	public Customer(String firstName, String lastName, String email) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	//for reading
	public Customer(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "Customer\n	 ID: " + id + "\n	 First Name: " + firstName + "\n	 Last Name: " + lastName + "\n	 Email: " + email + "\n\n";
	}
	
	
	
}
