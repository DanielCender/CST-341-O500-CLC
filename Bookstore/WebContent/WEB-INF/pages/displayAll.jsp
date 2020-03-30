<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<jsp:include page="../fragments/header.jsp" />
<body>

<jsp:include page="../fragments/nav.jsp" />

<center>
<h3>All Books in Library</h3>
<hr />

	<table>
		<tr>
			<th>Title</th>
			<th>Author</th>
			<th>ISBN</th>
			<th>Publisher</th>
			<th>Action</th>
		</tr>
	<c:forEach items="${books}" var="book">  
	

	<tr>
		<td>${book.title}</td>
		<td>${book.author}</td>
		<td>${book.ISBN}</td>
		<td>${book.publisher}</td>
		<td>
			<spring:url value="/products/${book.appId}/delete" var="deleteUrl" /> 
			<spring:url value="/products/${book.appId}/update" var="updateUrl" />

			<button class="btn btn-primary" 
                                          onclick="location.href='${updateUrl}'">Update</button>
			<%-- <button class="btn btn-danger" 
                                          onclick="post('${deleteUrl}')">Delete</button> --%>
            <form action="${deleteUrl}" method="POST">
        		<input class="btn btn-danger" type="submit" value="Delete"/>
			</form>
         </td>
   	</tr>
</c:forEach>
</table>
</center>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>