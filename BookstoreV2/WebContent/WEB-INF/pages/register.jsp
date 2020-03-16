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
</head>
	<body>
		<%@include file="header.html" %>
		<form:form method="POST" action="registerUser" modelAttribute ="userRegistration">

	    	<div class="form-group">
		        <form:label path="firstName">First Name: </form:label>
		        <form:input class="form-control" path="firstName"></form:input> 
		        <div class="invalid-feedback">
			        <form:errors path="firstName" />
			    </div>
		    </div>
	        
	        <br />
	        
	        <div class="form-group">
		        <form:label path="middleInitial">Middle Initial: </form:label>
	        	<form:input class="form-control" path="middleInitial"></form:input> 
	        	<div class="invalid-feedback">
	        		<form:errors path="middleInitial" />
	        	</div>
	        </div>
	        
	        <br />
	        
	        <div class="form-group">
		        <form:label path="lastName">Last Name: </form:label> 
		        <form:input class="form-control" path="lastName"></form:input> 
		        <div class="invalid-feedback">
		        	<form:errors path="lastName" />
		        </div>
	        </div>
	        
	        <br />
	        
	        <div class="form-group">
		        <form:label path="email">Email: </form:label>
		        <form:input class="form-control" path="email"></form:input> 
		        <div class="invalid-feedback">
			        <form:errors path="email" />
			    </div>
	        </div>
	        
	        <br />
	       
			<div class="form-group">
		        <form:label path="username">Username: </form:label>
		        <form:input class="form-control" path="username"></form:input> 
		        <div class="invalid-feedback">
		        	<form:errors path="username"/>
		        </div>
	        </div>
	        
	        <br />
	        
	        <div class="form-group">
		        <form:label path="password">Password: </form:label>
		        <form:input class="form-control" path="password"></form:input> 
		        <div class="invalid-feedback">
		        	<form:errors path="password" />
		        </div>
	        </div>
	        
	        <br />
	     
	     	<div class="form-group">
		        <form:label path="passwordConfirmation">Confirm Password: </form:label>
		        <form:input class="form-control" path="passwordConfirmation"></form:input> 
		        <div class="invalid-feedback">
			        <form:errors path="passwordConfirmation" />
	        	</div>
	        </div>
	        
	        <br />
	        
	        <input type="submit" class="btn btn-primary" value="Submit" />
		</form:form>
	    	
    	
    	<hr />
	  	<small class="form-text text-muted">Follow us on Social Media | &copy; since 2020 | Published at GCU </small>
	</body>
</html>