<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<style>
			form {
				width: 30%;
				height: 50%;
				padding-top: 10px;
				margin: 40px 35%;	
			}
		</style>
	    <title>Login</title>
	</head>
	<body>
		<%@include file="header.html" %>
			<form:form method="POST" action="loginUser" modelAttribute ="loginCModel">		    
		        <div class="form-group">
			        <form:label path="email">Email: </form:label> 
			        <form:input class="form-control" path="email"></form:input>
		        </div>
		        <br />
		        <div class="form-group">
			        <form:label path="password">Password: </form:label> 
			        <form:input class="form-control" path="password"></form:input> 
 			    </div>
		        <br/>
		        <div class="invalid-feedback">
			        <form:errors path="*" />
		        </div>
		        <br />
		        <input class="btn btn-primary" type="submit" value="Submit"/>
		  	</form:form>
	  		<br />
	  		<br />
	  		<br />
	  		<br />
	  	<hr />
	  	
	        <small class="form-text text-muted">Follow us on Social Media | &copy; since 2020 | Published at GCU </small>
	</body>
</html>