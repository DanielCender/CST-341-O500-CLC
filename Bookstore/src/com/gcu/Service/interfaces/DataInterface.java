package com.gcu.Service.interfaces;


public interface DataInterface<Y> {

	public boolean create(Y y);
	public boolean update(Y y);
	
	public Y findByID(int ID);
}
