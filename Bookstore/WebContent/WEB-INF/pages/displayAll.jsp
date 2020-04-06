<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<script src="https://code.jquery.com/jquery-3.2.1.min.js"></script>
	<title>All Books</title>
	<script>
		$(document).on('click', '.btn', function() {
			var title = $(this).attr('data-title');
			var author = $(this).attr('data-author');
			var publisher = $(this).attr('data-publisher');			
			var isbn = $(this).attr('data-isbn');
			
			$('.modal').find('#booktitle').val(title);
			$('.modal').find('#bookauthor').val(author);
			$('.modal').find('#bookpublisher').val(publisher);
			$('.modal').find('#bookisbn').val(isbn);
		})     	
	
	
	</script>
</head>

<jsp:include page="../fragments/header.jsp" />
<body>

<jsp:include page="../fragments/nav.jsp" />

<h3>All Books in Library</h3>
<hr />

<!-- LOOP THROUGH BOOKS -->
<div class="container">
	<div class="row">
	<c:forEach items="${books}" var="book"> 
		<div class="col-sm">
			<div class="card text-center" style="width: 18rem;">
			  	<div class="card-body">
			    	<h5 class="card-title">${book.title}</h5>
			    	<button id="${book.title}" class="btn btn-primary bookButton" data-toggle="modal" type="button" data-target="#bookModal" 
			    		data-title="${book.title}" 
			    		data-author="${book.author}"
			    		data-publisher="${book.publisher}"
			    		data-isbn="${book.ISBN}">
			    			Details
			    		</button>
			 	</div>
			</div>	
		</div>
	</c:forEach>
	</div>
</div>	


<!-- MODAL CODE -->


<div class="modal fade right" id="bookModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
  aria-hidden="true">

  <!-- Add class .modal-full-height and then add class .modal-right (or other classes from list above) to set a position to the modal -->
  <div class="modal-dialog modal-full-height modal-right" role="document">


    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title w-100" id="myModalLabel">Modal title</h4>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div class="modal-body">
        <strong>Title:</strong><input class="form-control" type="text" name="booktitle" id="booktitle" value=""/>
      	<br/><hr/>
      	<strong>Author:</strong><input class="form-control" type="text" name="bookauthor" id="bookauthor" value=""/>
        <br/><hr/>
        <strong>Publisher:</strong><input class="form-control" type="text" name="bookpublisher" id="bookpublisher" value=""/>
        <br/><hr/>
        <strong>ISBN:</strong><input class="form-control" type="text" name="bookisbn" id="bookisbn" value=""/>
        <br> 
      </div>
      <div class="modal-footer justify-content-center">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
      </div>
    </div>
  </div>
</div>


<jsp:include page="../fragments/footer.jsp"/>
</body>





</html>


