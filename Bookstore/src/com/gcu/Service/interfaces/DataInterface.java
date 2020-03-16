package com.gcu.Service.interfaces;

import java.sql.SQLException;

public interface DataInterface<Y> {

	public boolean create(Y y) throws SQLException, ClassNotFoundException;
	public boolean update(Y y) throws SQLException, ClassNotFoundException;
	
	public Y findByID(int ID);
}
