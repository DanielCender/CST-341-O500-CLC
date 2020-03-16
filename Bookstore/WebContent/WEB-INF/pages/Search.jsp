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
            font-size: 35px;
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
    </style>
</head>
<body>

    <header>

        Welcome to the Search Page <br><a href="/Bookstore/loginUser">Login</a>| <a href="/Bookstore/">Home</a>|<br><a href="/Bookstore/registerUser">Register</a>
      
    </header>
<form:form method="POST" action="" modelAttribute ="">

    <center>
        <form:label path="bookName">BookName: </form:label>
         <form:input path="bookName"></form:input> 
        <br />
         <form:label path="author">Author: </form:label>
          <form:input path="author"></form:input> 
        <br />
        <form:label path="ISBN">ISBN: </form:label> 
         <form:input path="ISBN"></form:input> 
        <br />
        <form:label path="genre">Genre: </form:label>
         <form:input path="genre"></form:input> 
        <br />
       
        <input type="submit" value="Submit"/>
        
    </center>
</form:form>
    <footer>
        Follow us on Social Media | &copy; since 2020 | Published in GCU
    </footer>
</body>
</html>