package com.gcu.Service.interfaces;


import com.gcu.models.BookModel;

public interface BookServiceInterface extends DataInterface<BookModel>{
	
	public BookModel findByID(int ID);
}
