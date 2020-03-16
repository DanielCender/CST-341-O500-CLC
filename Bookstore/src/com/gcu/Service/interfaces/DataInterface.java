package com.gcu.interfaces;

import java.util.List;

import com.gcu.models.BookModel;

public interface DataInterface<Y> {

	public boolean create(Y y);
	public boolean update(Y y);
	
	public List<BookModel> findByID(int bookID);
}
