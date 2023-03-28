<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

  <title>Leave your Contact Details Here</title>
  </head>
  <body>
    <h4>${top}</h4>
    <form action="processform" method="post">
    
    	<div class="container" mt-10>
    	
    		<h3 class="text-center">Contact Details</h3>
    	
    		<div class="form-group">
			    <label for="exampleInputEmail1">Email address</label>
			    <input type="email" 
			    class="form-control" 
			    id="exampleInputEmail1" 
			    aria-describedby="emailHelp" 
			    placeholder="Enter email"
			    name = "email">
			</div>
			
			<div class="form-group">
			    <label for="name">Name</label>
			    <input type="name" 
			    class="form-control" 
			    id="name" 
			    aria-describedby="emailHelp" 
			    placeholder="Enter name"
			    name="name">
			</div>
			
			<div class="form-group">
			    <label for="phone">Phone Number</label>
			    <input type="phone" 
			    class="form-control" 
			    id="phone" 
			    aria-describedby="emailHelp" 
			    placeholder="Enter Phone Number"
			    name="phone">
			</div>
			
			<div class="form-group">
			    <label for="info">Additional Information</label>
			    <input type="info" 
			    class="form-control" 
			    id="info" 
			    aria-describedby="emailHelp" 
			    placeholder="Enter Additional Information"
			    name="info">
			</div>
			
			<div class="container text-center">
				<button type="submit" class="btn btn-success">Send
				</button>
			</div>
    	
    	</div>
    
    </form>

    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>