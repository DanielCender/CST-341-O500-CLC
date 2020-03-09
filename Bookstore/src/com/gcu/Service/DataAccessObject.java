package com.gcu.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import com.gcu.models.UserModel;

 

public class DataAccessObject {

	private Connection conn = null;
	
	private Boolean getConnection() throws SQLException, ClassNotFoundException
	{
		Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		try
		{
			// TODO - Change String below to come from configuration file
			String connectionUrl = "jdbc:sqlserver://localhost:1433;databaseName=Bookstore;user=sa;password=Passw0rd1!;"; 
			
			this.conn = DriverManager.getConnection(connectionUrl);
			
			if (this.conn != null)
				return true;
			else return false;
		} catch (SQLException e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public Boolean Login(String Email, String Password) throws SQLException, ClassNotFoundException
	{
		//establish connection to db
		this.getConnection();
		
		//create string for logging in using email and password
		String LoginString = "SELECT COUNT(*) AS [Count] FROM Users WHERE Email = '" + Email + "' AND Password = '" + Password + "';";
		
		//create statement
		Statement stmt = this.conn.createStatement();
		
		//execute statement with query string and save that query to result set
		ResultSet rs = stmt.executeQuery(LoginString);
		
		rs.next(); // move to only row
		Integer rowsEffected = rs.getInt("Count");
		
		System.out.println("Rows found: " + rowsEffected);
		
		Boolean isAuthed = rowsEffected == 1;
		
		this.conn.close();
				
		return isAuthed;
	}
	
	public Boolean isAvailable(UserModel user) throws SQLException, ClassNotFoundException {
		this.getConnection();
		
		// '" + user.getEmail() + "'
		String checkExists = "SELECT COUNT(*) AS [Count] from [dbo].[Users] WHERE [Email] = '" + user.getEmail() + "';";
		
		System.out.println("To be executed: " + checkExists);
		//create SQL statement
		Statement stmt = this.conn.createStatement();
		ResultSet rs = stmt.executeQuery(checkExists);
			
		rs.next(); // move to only row
		Integer rowsEffected = rs.getInt("Count");
		
		System.out.println("Rows found: " + rowsEffected);
		
		Boolean isAvailable = rowsEffected == 0;
		
		this.conn.close();
				
		return isAvailable;
	}
	
	public Boolean Register(UserModel user) throws SQLException, ClassNotFoundException
	{
		//establish connection to db
		this.getConnection();
		
		//SQL string to add user to users table
		String InsertUser = "INSERT INTO [dbo].[Users] (FirstName, MiddleInitial, LastName, Username, Password, Email) Values ('" 
				+ user.getFirstName() + "', '"
				+ user.getMiddleInitial() + "', '"
				+ user.getLastName() + "', '" 
				+ user.getUsername() + "', '"
				+ user.getPassword() + "', '"
				+ user.getEmail() + "');";
		
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
