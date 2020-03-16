package com.gcu.Service;

import com.gcu.Service.interfaces.BookServiceInterface;
import com.gcu.models.BookModel;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class BookService implements BookServiceInterface {

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
	
	@Override
	public boolean create(BookModel y) throws SQLException, ClassNotFoundException {
		//SQL string to add user to users table
				String InsertBook = "INSERT INTO [dbo].[Books] (Title, Author, ISBN, Publisher) Values ('" 
						+ y.getTitle() + "', '"
						+ y.getAuthor() + "', '"
						+ y.getISBN() + "', '" 
						+ y.getPublisher() + "');";
				
				this.getConnection();
				
				//create SQL statement
				Statement stmt = this.conn.createStatement();
				
				//execute update using sql string and save result
				int rowsEffected = stmt.executeUpdate(InsertBook);
				
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

	@Override
	public boolean update(BookModel y) {
		Boolean success = false;
		// TODO Not Implemented
		
		return success;
	}

	@Override
	public BookModel findByID(int ID) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
