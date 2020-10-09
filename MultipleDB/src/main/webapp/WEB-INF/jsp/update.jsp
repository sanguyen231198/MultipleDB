<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
th, td {
	padding: 5px;
}

table {
	border-collapse: collapse;
}
</style>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<p>Successful</p>
	<h3>MySQL</h3>

	<table border="1">
		<tr>
			<th>Username</th>
			<th>Password</th>
		</tr>
		
			<tr>
				
				<td>${userPostgres.username}</td>
				<td>${userPostgres.password}</td>
			</tr>
	
	</table>

	


</body>
</html>