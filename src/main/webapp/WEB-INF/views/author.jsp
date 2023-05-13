<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Author-project</title>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
</head>
<body>
	<div class="container">
		<h2>Authors</h2>
		<table>

			<tr style="background-color: lightblue">
				<th>ID</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Birth Date</th>
				<th>Nationality</th>
			</tr>

			<c:forEach items="${authors}" var="author" varStatus="status">

				<!-- create an "update" link with Author id -->
				<c:url var="updateLink" value="/authors/update">
					<c:param name="id" value="${author.id}" />
				</c:url>

				<!-- create an "delete" link with Author id -->
				<c:url var="deleteLink" value="/authors/delete">
					<c:param name="id" value="${author.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'white':'yellow'}">
					<td>${author.id}</td>
					<td>${author.firstName}</td>
					<td>${author.lastName}</td>
					<td>${author.birthDate}</td>
					<td>${author.nationality}</td>
					<td>
						<!-- show the links -->
						<a class="update" href="${updateLink}">Update</a>
						<a class="delete" href="${pageContext.request.contextPath}/authors/delete/${author.id}">Delete</a>
					</td>

				</tr>
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/authors/new">Add Author</a>
	</div>
</body>
</html>
