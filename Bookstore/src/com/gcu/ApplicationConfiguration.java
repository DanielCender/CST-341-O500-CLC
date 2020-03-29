package com.gcu;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.gcu.business.BookBusinessService;
import com.gcu.business.DataBusinessInterface;
import com.gcu.business.UserBusinessInterface;
import com.gcu.business.UserBusinessService;
import com.gcu.data.DataAccessObject;
import com.gcu.data.DataInterface;
import com.gcu.data.UserDataInterface;
import com.gcu.models.BookModel;
import com.gcu.models.UserModel;

//import com.gcu.controllers.BaseController;
//import com.gcu.controllers.ProductController;
//import com.gcu.controllers.UserController;
//import com.gcu.data.BookService;

@Configuration
class ApplicationConfiguration {
//	@Bean(name="UserController") 
//	public UserController getUserController() {
//		return new UserController();
//	}
//	@Bean(name="ProductController")
//	public ProductController getProductController() {
//		return new ProductController();
//	}
//	
//	@Bean(name="BaseController")
//	public BaseController getBaseController() {
//		return new BaseController();
//	}
	
//	@Bean(name="BookService")
//	public BookServiceInterface getBookServiceInterface() {
//		return new BookService();
//	}
	
	@Bean(name="UserService")
	@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public UserBusinessInterface getUserBusinessInterface() {
		return new UserBusinessService();
	}
	
	@Bean(name="BookService")
	@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DataBusinessInterface<BookModel> getDataBusinessInterface() {
		return new BookBusinessService();
	}
//	@Bean(name="DataService")
//	@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
//	public UserDataInterface getUserDataInterface() {
//		return new DataAccessObject();
//	}
	
//	@Bean(name="Service")
//	public DataInterface<UserModel> getDataAccessInterface() {
//		return new DataAccessObject();
//	}
	
	@Bean(name="jdbcTemplate")
	@Scope(value="request", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=Bookstore;user=sa;password=Passw0rd1!;");
//		ds.setUsername("user");
//		ds.setPassword("derby");
		return ds;
	}
	
	
	
}
