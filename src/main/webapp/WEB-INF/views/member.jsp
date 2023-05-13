<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<%@ page isELIgnored="false" %>
<meta charset="UTF-8">
<title>Member-project</title>

<link rel="stylesheet"  href="${pageContext.request.contextPath}/resources/css/style.css?version=1">
</head>
<body>
	<div class="container">
		<h2>Members</h2>
		<table>

			<tr style="background-color: lightblue">
				<th>ID</th>
				<th>Name</th>
				<th>Email</th>
				<th>Membership Date</th>
			</tr>

			<c:forEach items="${members}" var="member" varStatus="status">

				<!-- create an "update" link with Member id -->
				<c:url var="updateLink" value="/members/update">
					<c:param name="id" value="${member.id}" />
				</c:url>

				<!-- create an "delete" link with Member id -->
				<c:url var="deleteLink" value="/members/delete">
					<c:param name="id" value="${member.id}" />
				</c:url>

				<tr
					style="background-color:${status.index % 2==0? 'white':'yellow'}">
					<td>${member.id}</td>
					<td>${member.name}</td>
					<td>${member.email}</td>
					<td>${member.membershipDate}</td>
					<td>
						<!-- show the links -->
						<a class="update" href="${updateLink}">Update</a>
						<a class="delete" href="${pageContext.request.contextPath}/members/delete/${member.id}">Delete</a>
					</td>

				</tr>
			</c:forEach>
		</table>
		<p><a class="normal" href="${pageContext.request.contextPath}/members/new">Add Member</a>
	</div>
</body>
</html>
