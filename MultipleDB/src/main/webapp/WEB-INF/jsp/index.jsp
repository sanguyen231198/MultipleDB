<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">

<title>Insert title here</title>
</head>
<body>

	<h1>Welcome</h1>
	<h2>${message}</h2>

	<a href="${pageContext.request.contextPath}/list">Test</a>
	<a href="${pageContext.request.contextPath}/update">Test</a>
	
</body>
</html>