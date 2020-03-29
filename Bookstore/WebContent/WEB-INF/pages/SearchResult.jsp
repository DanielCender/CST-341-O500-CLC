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

        Welcome to the Search Page <br><a href="/Bookstore/login">Login</a>| <a href="/Bookstore/">Home</a>|<br><a href="/Bookstore/register">Register</a><br> | <a href="/Bookstore/Search">Search</a>
      
    </header>
<form:form method="Get" action="" modelAttribute ="">

    <center>
        <form:label path="bookName">BookName: </form:label>
       
        <br />
         <form:label path="author">Author: </form:label>
 
        <br />
        <form:label path="ISBN">ISBN: </form:label> 
         
        <br />
         <form:label path="publisher">Publisher: </form:label> 
        
         <br/>
        <form:label path="genre">Genre: </form:label>
       
        <br />
       
      
        
    </center>
</form:form>
    <footer>
        Follow us on Social Media | &copy; since 2020 | Published in GCU
    </footer>
</body>
</html>