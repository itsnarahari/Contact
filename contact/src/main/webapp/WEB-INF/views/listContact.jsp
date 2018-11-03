<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Students</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>Student ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Course</th>
				<th>Year</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${contact}" var="contact">
				<tr>
					<td><c:out value="${contact.id}" /></td>
					<td><c:out value="${contact.fname}" /></td>
					<td><c:out value="${contact.lname}" /></td>
					<td><c:out value="${contact.email}" /></td>
					<td><c:out value="${contact.mobile}" /></td>
					<td><a
						href="ContactController.do?action=edit&id=<c:out value="${contact.id }"/>">Update</a></td>
					<td><a
						href="ContactController.do?action=delete&id=<c:out value="${contact.id }"/>">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="ContactController.do?action=insert">Add Student</a>
	</p>
</body>
</html>