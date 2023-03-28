<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Certificates</title>
</head>
<body>
	<h1>List of certificates: </h1>
	<hr>
		<c:forEach var="irritrateOver" items="${certi}">
			<h3>${irritrateOver}</h3>		
		</c:forEach>
	</hr>
</body>
</html>