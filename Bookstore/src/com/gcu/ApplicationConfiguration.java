package com.gcu;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.gcu.Service.BookService;
import com.gcu.Service.interfaces.BookServiceInterface;
//import com.gcu.controllers.BaseController;
//import com.gcu.controllers.ProductController;
//import com.gcu.controllers.UserController;

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
	
	@Bean(name="BookService")
	public BookServiceInterface getBookServiceInterface() {
		return new BookService();
	}
	
	@Bean(name="jdbcTemplate")
	@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
	public DriverManagerDataSource getDataSource() {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		ds.setDriverClassName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		ds.setUrl("jdbc:sqlserver://localhost:1433;databaseName=Bookstore;user=sa;password=Passw0rd1!;");
//		ds.setUsername("user");
//		ds.setPassword("derby");
		return ds;
	}
	
}
