<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
	<title>All Books</title>
	<script>
		$(document).on('click', '.btn', function () {
			var book = $(this).data('bookdata');
			$('modal-body #booktitle').val(book);
			
		})	
	
	
		$('#bookModal').on('show.bs.modal', function (event) {
			  var button = $(event.relatedTarget) // Button that triggered the modal
			  var book = button.data('book') // Extract info from data-* attributes
			  // If necessary, you could initiate an AJAX request here (and then do the updating in a callback).
			  // Update the modal's content. We'll use jQuery here, but you could use a data binding library or other methods instead.
			  var modal = $(this)
			  modal.find('.modal-title').text('Test');
			  modal.find('.modal-body input').val(recipient)
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
			    	<button class="btn btn-primary" data-toggle="modal" type="button" data-target="#bookModal" data-bookdata="book">Test Modal</button>
			 	</div>
			</div>	
		</div>
	</c:forEach>
	</div>
</div>	


<jsp:include page="../fragments/footer.jsp"/>
</body>



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
      	<h5 id="bookTitle"></h5>
      		<strong>Title:</strong>
        
        <br/><hr/>
        <div id="bookAuthor">
        	<strong>Author:</strong>${book.author}
        </div>
        <br/><hr/>
        <br> 
      </div>
      <div class="modal-footer justify-content-center">
        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>

</html>


