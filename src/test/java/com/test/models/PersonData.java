package com.test.models;

public class PersonData implements BaseModel {

	public String name;
	public String email;
	public String password;
	
	public PersonData(String name, String email, String password) {
		super();
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}
	
	

}
