<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="row">
			<%@include file="navsearch.jsp" %>
		</div>
<%@include file="nav.jsp" %>
<div class="row">
	<section class="con-list-video bg-dark pb-4">
		<div class="container">
			<div class="row m-3">
				<c:forEach var="vd" items="${video }">
					<!-- item-video -->
					<div class="col-lg-4 mt-3">
						<div class="item-video p-3 rounded-3">
							<a href="/WebASMServlet/page-infomation/?watch=${vd.id }"
								class="d-flex justify-content-center"> <img
								src="/WebASMServlet/img/${vd.poster }" width="360px"
								height="202px" alt="">
							</a>
							<div class="box-tittle-video" style="height: 50px;">
								<h4 class="m-0 text-white text-center">${vd.tittle }</h4>
							</div>
						</div>
					</div>
				</c:forEach>
			</div>
		</div>
	</section>
</div>

 <div class="row">
        <%@include file="pagination.jsp" %>
  </div>