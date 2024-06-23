<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<nav class="navbar bg-body-tertiary">
	<div class="container-fluid">
		<form action="" method="post" class="d-flex" role="search">
			<select name="year"
				class="form-select form-select-sm form-control mx-2"
				aria-label="Small select example">
				<option selected>Year</option>
				<% for (int i = 2015; i < 2025; i++) { %>
				<option value="<%=i%>"><%=i%></option>
				<%
				}
				%>
			</select>
			<button class="btn btn-outline-success" type="submit">Search</button>
		</form>
	</div>
</nav>
<form style="height: 381px">
<table class="table">
	<thead>
		<tr>
			<th scope="col">Tittle</th>
			<th scope="col">Total views</th>
			<th scope="col">Total like</th>
			<th scope="col">Newest Date</th>
			<th scope="col">Oldest Date</th>
		</tr>
	</thead>

	<tbody>
		<c:forEach var="item" items="${report}">
			<tr>
				<td>${item.tittle}</td>
				<td>${item.views}</td>
				<td>${item.likecount}</td>
				<td>${item.newest}</td>
				<td>${item.oldest}</td>
			</tr>
		</c:forEach>
	</tbody>
</table>
</form>