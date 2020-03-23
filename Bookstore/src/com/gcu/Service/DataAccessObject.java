package com.gcu.Service;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.gcu.models.UserModel;

 
@Component
public class DataAccessObject {
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("Hello there from DataAccessObject: " + this.jdbcTemplate.toString());
	}
	
	public Boolean Login(String Email, String Password)
	{
		//create string for logging in using email and password
		String LoginString = "SELECT COUNT(*) AS [Count] FROM Users WHERE Email = ? AND Password = ?;";
		
		int rowsEffected = jdbcTemplate.queryForObject(LoginString, Integer.class, Email, Password);

		System.out.println("Rows found: " + rowsEffected);
		
		Boolean isAuthed = rowsEffected == 1;

		return isAuthed;
	}
	
	public Boolean isAvailable(UserModel user) {
		String checkExists = "SELECT COUNT(*) AS [Count] from [dbo].[Users] WHERE [Email] = ?;";
		
		System.out.println("To be executed: " + checkExists);
		Integer rowsEffected = jdbcTemplate.queryForObject(checkExists, Integer.class, user.getEmail());
		System.out.println("Rows found: " + rowsEffected);
		
		Boolean isAvailable = rowsEffected == 0;
				
		return isAvailable;
	}
	
	public Boolean Register(UserModel user)
	{
		String InsertUser = "INSERT INTO [dbo].[Users] (FirstName, MiddleInitial, LastName, Username, Password, Email) Values (?,?,?,?,?,?);";
		
		//execute update using sql string and save result
		int result = jdbcTemplate.update(InsertUser, user.getFirstName(), user.getMiddleInitial(), user.getLastName(), user.getUsername(), user.getPassword(), user.getEmail());

		return result > 0;
	}
	

}
