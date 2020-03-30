<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<jsp:include page="../fragments/header.jsp" />
<body>

<jsp:include page="../fragments/nav.jsp" />
<center>
<h3>Book Details:</h3>
<table>
	<!-- <tr>
			<th>Title</th>
			<th>Author</th>
			<th>ISBN</th>
			<th>Publisher</th>
			<th>Action</th>
		</tr> -->
	<tr>
		<th>Title:</th>
		<td>${book.title}</td>
	</tr>
	<tr>
		<th>Author:</th>
		<td>${book.author}</td>
	</tr>
	<tr>
		<th>ISBN:</th>
		<td>${book.ISBN}</td>
	</tr>
	<tr>
		<th>Publisher:</th>
		<td>${book.publisher}</td>
	</tr>
</table>
</center>

<jsp:include page="../fragments/footer.jsp"/>
</body>
</html>