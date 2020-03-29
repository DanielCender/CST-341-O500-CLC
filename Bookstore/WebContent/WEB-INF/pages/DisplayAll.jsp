<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<%@include file="header.html" %>
</head>
<body>
<center>
Display of Your Books:
</center>
<center>
	<c:forEach items="${BookForms}" var="BookForm">  
	
   Title : <c:out value="${BookForm.Title}"/>
   Author :<c:out value="${BookForm.Author}"/>
   ISBN : <c:out value="${BookForm.ISBN}"/>
   Publisher : <c:out value="${BookForm.Publisher}"/>
   <br/>
   <form:form method="POST" action="Delete" modelAttribute ="book">  
   <form:label path="title">Enter Book Title to Delete: </form:label>
   <br/>
         <form:input path="title"></form:input> 
         <br/>
         </form:form>
   <input type="submit" value="Delete" />
   <br/>
      <form:form method="POST" action="Update" modelAttribute ="book">  
 
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
        <input type="submit" value="Edit" />

   </form:form>
</c:forEach>
</center>


</body>
</html>