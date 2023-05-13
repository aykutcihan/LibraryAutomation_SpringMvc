<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Book-project</title>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
</head>
<body>
	<div class="container">
		<h2>Books</h2>
		<table>

			<tr style="background-color: lightblue">
				<th>ID</th>
				<th>Title</th>
				<th>Publish Date</th>
				<th>Genre</th>
			</tr>

			<c:forEach items="${books}" var="book" varStatus="status">

				<!-- create an "update" link with Book id -->
				<c:url var="updateLink" value="/books/update">
					<c:param name="id" value="${book.id}" />
				</c:url>

				<!-- create an "delete" link with Book id -->
				<c:url var="deleteLink" value="/books/delete">
					<c:param name="id" value="${book.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'white':'yellow'}">
					<td>${book.id}</td>
					<td>${book.title}</td>
					<td>${book.publishDate}</td>
					<td>${book.genre}</td>
					<td>
						<!-- show the links -->
						<a class="update" href="${updateLink}">Update</a>
						<a class="delete" href="${pageContext.request.contextPath}/books/delete/${book.id}">Delete</a>
					</td>

				</tr>
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/books/new">Add Book</a>
	</div>
</body>
</html>
