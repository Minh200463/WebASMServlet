<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<div class="row">
	<%@include file="navsearch.jsp"%>
</div>
	<div class="row">
		<div class="con-list-video bg-secondary">
			<div class="container">
				<div class="row mb-4">
					<h4 class="m-3 text-white border-bottom p-2">List liked video</h4>

					<!-- item -->
					<c:forEach var="item" items="${video }">
						<div class="col-lg-3">
							<div class="item-video m-1 p-2 rounded-3">
								<div class="video d-flex justify-content-center">
									<img src="/WebASMServlet/img/${item.poster }"
										class="p-1 rounded-4" width="250px" alt="img-poster-video">
								</div>
								<h5 class="pb-2 text-white text-center">${item.tittle }</h5>
								<div class="box-btn d-flex justify-content-around">
									<button class="btn btn-outline-light btn-like" type="submit">
										<i class="bi bi-heart"></i> Unlike
									</button>
									<button class="btn btn-success btn-share bg-success"
										type="button" data-bs-toggle="modal"
										data-bs-target="#staticBackdrop">
										<i class="bi bi-share"></i> Share
									</button>
								</div>
							</div>
						</div>
					</c:forEach>


					<!-- Modal -->
					<div class="modal fade" id="staticBackdrop"
						data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
						aria-labelledby="staticBackdropLabel" aria-hidden="true">
						<div class="modal-dialog">
							<div class="modal-content">
								<div class="modal-header">
									<h1 class="modal-title fs-5" id="staticBackdropLabel">Share
										video to</h1>
									<button type="button" class="btn-close" data-bs-dismiss="modal"
										aria-label="Close"></button>
								</div>
								<div class="modal-body">
									<div class="mb-3">
										<label for="exampleInputEmail1" class="form-label">Email
											address</label> <input type="email" class="form-control"
											id="exampleInputEmail1" aria-describedby="emailHelp" required>
										<div id="emailHelp" class="form-text">We'll never share
											your email with anyone else.</div>
									</div>
								</div>
								<div class="modal-footer">
									<button type="button" class="btn btn-secondary"
										data-bs-dismiss="modal">Close</button>
									<button type="submit" class="btn btn-primary">Share</button>
								</div>
							</div>
						</div>
					</div>

				</div>

			</div>
		</div>
	</div>
<div class="row">
	<%@include file="pagination.jsp"%>
</div>