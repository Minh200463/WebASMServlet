<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="col-12 col-xxl-5">
	<c:forEach var="item" items="${item4video}">
		<!-- Item -->
	<div class="item-poster border-bottom rounded-2 p-3">
		<a href="/WebASMServlet/page-infomation/?watch=${item.id }"
		class="link-offset-2 link-underline link-underline-opacity-0">
		<div class="poster-video d-flex">
			<img src="/WebASMServlet/img/${item.poster }" class="p-1 rounded-4"
				width="180px" alt="img-poster-video">
			<div class="info p-2">
				<h3 class="tittle-video text-white">${item.tittle }</h3>
				<p class="text-break text-dark">${item.description}</p>
			</div>
		</div>
		</a>
	</div>
	</c:forEach>
</div>