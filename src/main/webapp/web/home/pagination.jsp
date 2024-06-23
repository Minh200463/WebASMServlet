<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="box-pagination">
	<nav aria-label="Page navigation example">
		<form action="" >
			<ul class="pagination justify-content-center pt-3">
				<c:forEach begin="1" end="${counttt}" var="count">
					<li class="page-item mx-1"><a class="page-link bg-dark"
						href="/WebASMServlet/page-pagination/?page-item=${count}">${count}</a></li>
				</c:forEach>
			</ul>
		</form>
	</nav>
</div>
