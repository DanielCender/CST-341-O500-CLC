package com.gcu.Service;

import com.gcu.Service.interfaces.BookServiceInterface;
import com.gcu.models.BookModel;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class BookService implements BookServiceInterface {
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
		System.out.println("Hello there from DataAccessObject: " + this.jdbcTemplate.toString());
	}
	
	@Override
	public boolean create(BookModel y) {
		//SQL string to add user to users table
				String InsertBook = "INSERT INTO [dbo].[Books] (Title, Author, ISBN, Publisher) Values (?,?,?,?);";
				
				int result = jdbcTemplate.update(InsertBook, y.getTitle(), y.getAuthor(), y.getISBN(), y.getPublisher());

				return result > 0;
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
