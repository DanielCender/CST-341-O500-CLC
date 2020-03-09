<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Register</title>
    <style>

        body {
            font-family: Arial, Helvetica, sans-serif;
            color: white;
            background-color: lightgray;
        }

        header {
            background-color: darkgray;
            padding: 30px;
            text-align: center;
            font-size: 2rem;
            color: white;
        }

        h1 {
            text-align: center;
        }

        /* Style the footer */
        footer {
            background-color: #777;
            padding: 10px;
            text-align: center;
            color: white;
        }
        
        .error {
        	color: red;
        }
    </style>
</head>
<body>

    <header>

        Welcome to the Regsitration Page <br><a href="/Bookstore/loginUser">Login</a> <a href="/Bookstore/">Home</a>|<br>
      
    </header>
<form:form method="POST" action="registerUser" modelAttribute ="userRegistration">

    <center>
        <form:label path="firstName">First Name: </form:label>
         <form:input path="firstName"></form:input> 
        <br />
         <form:label path="middleInitial">Middle Initial: </form:label>
          <form:input path="middleInitial"></form:input> 
        <br />
        <form:label path="lastName">Last Name: </form:label> 
         <form:input path="lastName"></form:input> 
        <br />
        <form:label path="email">Email: </form:label>
         <form:input path="email"></form:input> 
        <br />
       
 
        <form:label path="username">Username: </form:label>
         <form:input path="username"></form:input> 
        <br />
        <form:label path="password">Password: </form:label>
         <form:input path="password"></form:input> 
        <br />
        <form:label path="passwordConfirmation">Password: </form:label>
         <form:input path="passwordConfirmation"></form:input> 
        <br />
        
        <form:errors path="*" cssClass="error"/>
        <br />
        <input type="submit" value="Submit" />
    </center>
</form:form>
    <footer>
        Follow us on Social Media | &copy; since 2020 | Published in GCU
    </footer>
</body>
</html>