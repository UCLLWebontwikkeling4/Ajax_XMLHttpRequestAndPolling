<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Lector Example - Ajax - XMLHttpRequest and Polling</title>
</head>
<body>
	<h1>Lectors</h1>
	<table>
		<thead>
		<tr>
			<th>Name</th>
			<th>Firstname</th>
		</thead>
		<tbody>
		<c:forEach var="lector" items="${lectors}">
			<tr>
				<td>${lector.name}</td>
				<td>${lector.firstname}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
</body>
</html>