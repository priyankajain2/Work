<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import ="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>This is a about page</title>
</head>
<body>
	<h1>Hi! Let me introduce myself</h1>
	
	<%
	String name = (String)request.getAttribute("name");
	String edu = (String)request.getAttribute("edu");
	List<String> projects = (List<String>)request.getAttribute("project");
	%>
	
	<h1>Myself, <%=name %></h1>
	<h1>Currently pursuing <%=edu %></h1>
	<h1>Projects</h1>
	<% for(String p : projects){%>
	
		<h3> <%=p %></h3>
	<% } %>
	
</body>
</html>