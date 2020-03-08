package com.gcu.models;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class UserModel {

	@NotNull(message="First Name is required")
	private String firstName;
	@NotNull(message="Middle Initial is required")
	private String middleInitial;
	@NotNull(message="Last Name is required")
	private String lastName;	
	@NotNull(message="Username is required")
	private String username;
	@NotNull(message="Password is required")
	private String password;
	@Email
	@NotNull(message="Email is required")
	private String email;
	
	/*getters and setters*/
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	public String getMiddleInitial() {
		return middleInitial;
	}
	public void setMiddleInitial(String middleInitial) {
		this.middleInitial = middleInitial;
	}
	
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
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
	
	/*constructor with params*/
	public UserModel(@NotNull(message = "First Name is required") String firstName,
			@NotNull(message = "Middle Initial is required") String middleInitial,
			@NotNull(message = "Last Name is required") String lastName,
			@NotNull(message = "Username is required") String username,
			@NotNull(message = "Password is required") String password,
			@Email @NotNull(message = "Email is required") String email) {
		super();
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.lastName = lastName;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	/*constructor without params*/
	public UserModel() { }
	
}
