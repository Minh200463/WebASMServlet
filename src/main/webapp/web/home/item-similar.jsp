<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="row bg-secondary">
	<div class="con-list-video p-3">
		<div class="container">
			<div class="row justify-content-around">
				<h5 class="text-white mb-3">Similar Footage</h5>
				<c:forEach var="item" items="${itemvideo }">
					<!-- item -->
					<div class="item-video col-lg-4 mb-5 p-2 rounded-3"
						style="width: 350px;">
						<a href="/WebASMServlet/page-infomation/?watch=${item.id }"
							class="link-offset-2 link-underline link-underline-opacity-0">
							<div class="video d-flex justify-content-center">
								<img src="/WebASMServlet/img/${item.poster }"
									class="poster-video p-1 rounded-4" width="320px"
									alt="img-poster-video">
							</div>
							<h5 class="m-0 text-white text-center">${item.tittle}</h5>
						</a>
					</div>
				</c:forEach>
			</div>
		</div>
	</div>
</div>