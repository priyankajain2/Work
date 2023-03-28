<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Work Experience</title>
</head>
<body>
	<%
		String name = (String)request.getAttribute("name");
		String duration = (String)request.getAttribute("duration");
		String designation = (String)request.getAttribute("designation");
	%>
	
	<h1>I worked in <%=name %> as a <%=designation %> from <%=duration %>.</h1>
</body>
</html>