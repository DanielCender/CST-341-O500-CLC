<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="ISO-8859-1">
    <title>Add Book</title>
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

        Welcome to the Book Registration Page <br><a href="/Bookstore/">Home</a>|<br>
      
    </header>
<form:form method="POST" action="registerBook" modelAttribute ="book">

    <center>
        <form:label path="title">Title: </form:label>
         <form:input path="title"></form:input> 
        <form:errors path="title" />
        <br />
         <form:label path="author">Author: </form:label>
          <form:input path="author"></form:input> 
          <form:errors path="author" />
        <br />
        <form:label path="ISBN">ISBN: </form:label> 
         <form:input path="ISBN"></form:input> 
         <form:errors path="ISBN" />
        <br />
        <form:label path="publisher">Publisher: </form:label>
         <form:input path="publisher"></form:input> 
         <form:errors path="publisher" />
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