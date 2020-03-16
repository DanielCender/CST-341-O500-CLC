package com.gcu.models;

public class BookModel {
	
	//Basic variables for books along with an identification number

	private String author;
	
	private String title;
	
	private int bookID;
	
	public BookModel() {
		
	}
	
	public BookModel(String author, String title, int bookID) {
		this.setAuthor(author);
		this.setTitle(title);
		this.setBookID(bookID);
	}
	
	//Getter and setter's for the variables.

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getBookID() {
		return bookID;
	}

	public void setBookID(int bookID) {
		this.bookID = bookID;
	}
	
	
	
	
}
