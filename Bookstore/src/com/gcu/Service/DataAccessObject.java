package com.gcu.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.gcu.models.UserModel;

 

public class DataAccessObject {

	private Connection conn = null;
	
	public Boolean getConnection() throws SQLException
	{
		try
		{
			String dbUrl = "jdbc:sqlserver://localhost";
			conn = DriverManager.getConnection(dbUrl, "LAPTOP-9IVBT4NR/David Pratt Jr", "");
			
			if (conn != null)
				return true;
			else return false;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean Login(String Username, String Password) throws SQLException
	{
		//establish connection to db
		this.getConnection();
		
		//create string for logging in using username and password
		String LoginString = "SELECT * FROM Users WHERE Username = '" + Username + "' AND Password = '" + Password + "';";
		
		//create statement
		Statement stmt = conn.createStatement();
		
		//execute statement with query string and save that query to result set
		ResultSet result = stmt.executeQuery(LoginString);
		
		//if result has an item within it; return true;
		if (result.next())
		{
			this.conn.close();
			return true;
		}
		
		//otherwise return false
		this.conn.close();
		return false;
	}
	
	public Boolean Register(UserModel user) throws SQLException
	{
		//establish connection to db
		this.getConnection();
		
		//SQL string to add user to users table
		String InsertUser = "INSERT INTO dbo.Users (FirstName, MiddleInitial, LastName, Username, Password, Email) Values ('" 
				+ user.getFirstName() + "', '"
				+ user.getMiddleInitial() + "', '"
				+ user.getLastName() + "', '" 
				+ user.getUsername() + "', '"
				+ user.getPassword() + "', '"
				+ user.getEmail() + "';";
		
		//create SQL statement
		Statement stmt = this.conn.createStatement();
		
		//execute update using sql string and save result
		int rowsEffected = stmt.executeUpdate(InsertUser);
		
		//check effected rows if > 0 return true
		if (rowsEffected > 0)
		{
			this.conn.close();
			return true;
		}
		
		
		//otherwise return false
		this.conn.close();
		return false;
		
	}
	

}
