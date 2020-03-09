package com.gcu.models;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class RegisterUserModel extends UserModel {
	@NotNull
	@Size(min=6,max=20,message="Password confirmation must be between 6 and 20 chars")
	private String passwordConfirmation;
	
	public RegisterUserModel() {
		super();
	}

	public RegisterUserModel(String firstName, String middleInitial, String lastName, String username, String password,
			String email, String passwordConfirmation) {
		super(firstName, middleInitial, lastName, username, password, email);
		this.passwordConfirmation = passwordConfirmation;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}


}
