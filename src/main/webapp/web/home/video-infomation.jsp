<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="row">
			<%@include file="navsearch.jsp" %>
		</div>
<div class="row bg-secondary p-4 border-bottom border-2 border-dark">
	<div class="col-12 col-xl-7 p-0 ">
			<form action="" method="POST">
		<div class="infomation-video">
			<iframe width="825" height="520"
				src="https://www.youtube.com/embed/${video.href}"
				title="YouTube video player" frameborder="0"
				allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share"
				allowfullscreen></iframe>

			<div>
				<h3 class="text-white p-2">${video.tittle}</h4>
			</div>
			
				<button class="btn btn-outline-light btn-like"
			    value="btn-like" type="submit">
				<i class="bi bi-heart"></i> Like
			</button>
			<a class="btn btn-success btn-share bg-success" 
				href="/WebASMServlet/SendMail?watch=${video.id }">
				<i class="bi bi-share"></i> Share
			</a>
			
			<div class="description m-2">
				<p class="text-white p-2">${video.description }</p>
			</div>
		</div>
			</form>
	</div>
	<%@include file="item-navright.jsp"%>
</div>
<%@include file="item-similar.jsp"%>


<div class="row">
	<%@include file="pagination.jsp"%>
</div>