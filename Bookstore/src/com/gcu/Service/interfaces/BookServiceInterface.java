package com.gcu.interfaces;

import java.util.List;

import com.gcu.models.BookModel;

public interface BookServiceInterface extends DataInterface<BookModel>{

	public List<BookModel> findByID(int bookID);
	
}
