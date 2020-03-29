<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Home</title>
<style>
	#loginbtn {
		margin: 10px 40%;
	}
	
	#registerbtn {
		margin:  10px 40%;
	}
</style>
</head>
<body>
  <%@include file="header.html"%>
	<center>
    <blockquote>Welcome to the GCU Computer Science Online Book Store</blockquote>
	</center>
		
	<a href="/Bookstore/users/login" class="btn btn-primary" id="loginbtn">Login</a>
	
	<a href="/Bookstore/users/register" class="btn btn-primary" id="registerbtn">Register</a>
	
	<hr />
	<small class="form-text text-muted">Follow us on Social Media | &copy; since 2020 | Published at GCU </small>
</body>
</html>