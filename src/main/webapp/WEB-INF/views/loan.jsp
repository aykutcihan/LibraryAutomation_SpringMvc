<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Loan-project</title>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
</head>
<body>
	<div class="container">
		<h2>Loans</h2>
		<table>

			<tr style="background-color: lightblue">
				<th>ID</th>
				<th>Book</th>
				<th>Member</th>
				<th>Loan Date</th>
				<th>Return Date</th>
			</tr>

			<c:forEach items="${loans}" var="loan" varStatus="status">

				<!-- create an "update" link with Loan id -->
				<c:url var="updateLink" value="/loans/update">
					<c:param name="id" value="${loan.id}" />
				</c:url>

				<!-- create an "delete" link with Loan id -->
				<c:url var="deleteLink" value="/loans/delete">
					<c:param name="id" value="${loan.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'white':'yellow'}">
					<td>${loan.id}</td>
					<td>${loan.book.title}</td> <!-- Assuming 'book' object has 'title' attribute -->
					<td>${loan.member.name}</td> <!-- Assuming 'member' object has 'name' attribute -->
					<td>${loan.loanDate}</td>
					<td>${loan.returnDate}</td>
					<td>
						<!-- show the links -->
						<a class="update" href="${updateLink}">Update</a>
						<a class="delete" href="${pageContext.request.contextPath}/loans/delete/${loan.id}">Delete</a>
					</td>

				</tr>
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/loans/new">Add Loan</a>
	</div>
</body>
</html>
