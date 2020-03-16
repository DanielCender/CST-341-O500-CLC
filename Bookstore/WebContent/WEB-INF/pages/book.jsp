<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>View Book</title>
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

<h3>Book Registration Result:</h3>
<table>
	<tr>
		<td>Title:</td>
		<td>${book.title}</td>
	</tr>
	<tr>
		<td>Author:</td>
		<td>${book.author}</td>
	</tr>
	<tr>
		<td>ISBN:</td>
		<td>${book.ISBN}</td>
	</tr>
	<tr>
		<td>Publisher:</td>
		<td>${book.publisher}</td>
	</tr>
</table>

</body>
</html>