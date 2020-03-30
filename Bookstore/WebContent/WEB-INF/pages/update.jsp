<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../fragments/header.jsp" />
<body>

<jsp:include page="../fragments/nav.jsp" />

  <center>
<h3>Update Book Entry</h3>

<form:form method="POST" action="update" modelAttribute ="book">
  
        <form:label path="title">Title: </form:label>
         <form:input path="title" value="${book.title}"></form:input> 
        <form:errors path="title" />
        <br />
         <form:label path="author">Author: </form:label>
          <form:input path="author" value="${book.author}"></form:input> 
          <form:errors path="author" />
        <br />
        <form:label path="ISBN">ISBN: </form:label> 
         <form:input path="ISBN" value="${book.ISBN}"></form:input> 
         <form:errors path="ISBN" />
        <br />
        <form:label path="publisher">Publisher: </form:label>
         <form:input path="publisher" value="${book.publisher}"></form:input> 
         <form:errors path="publisher" />
        <br />
        <form:hidden path="appId" value="${book.appId}"></form:hidden>
        
        <form:errors path="*" cssClass="error"/>
        <br />
        <input type="submit" value="Submit" />

</form:form>
</center>
 
<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>