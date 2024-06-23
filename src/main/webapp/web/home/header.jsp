<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
	<div class="contai-header">
		<div class="row con-infomation-login">
			<nav class="navbar navbar-expand-lg">
				<div class="container">
					<a class="navbar-brand" href="/WebASMServlet/homepage"> <img src="./img/Logo.png"
						width="50px" alt="">
					</a>
					<button class="navbar-toggler" type="button"
						data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent"
						aria-controls="navbarSupportedContent" aria-expanded="false"
						aria-label="Toggle navigation">
						<span class="navbar-toggler-icon"></span>
					</button>
					<div class="collapse navbar-collapse" id="navbarSupportedContent">
						<ul class="navbar-nav me-auto mb-2 mb-lg-0">

						</ul>

						<c:choose>
							<c:when test="${empty sessionScope.user}">
								<form class="d-flex m-0" role="search">
									<ul class="navbar-nav mx-auto mb-2 mb-lg-0 fw-bold">
										<li class="nav-item mx-2">
										<a type="button" class="btn btn-primary"
										href="/WebASMServlet/register">Register</a>
										</li>
										<li class="nav-item">
										<a type="button" class="btn btn-outline-danger"
										href="/WebASMServlet/login">Login</a>
										</li>
									</ul>
								</form>
							</c:when>
							<c:otherwise>
								<form class="d-flex m-0" role="search">
									<ul class="navbar-nav mx-auto mb-2 mb-lg-0 fw-bold lh-5 fs-6">	
									 <li class="nav-item">
            							<a class="nav-link" href="/WebASMServlet/homepage ">
            							<i class="bi bi-house-door-fill fs-4"></i> Home</a></li>
            							<a class="nav-link" href="/WebASMServlet/homepage">
            							<i class="bi bi-file-text fs-4"></i> About Us</a></li>
										<li class="nav-item dropdown">
											<div>
												<a class="nav-link dropdown-toggle"
													data-bs-toggle="dropdown" href="#" role="button"
													aria-expanded="false">
													<i class="bi bi-person-circle fs-4"></i> ${sessionScope.user.username}</a>
												<ul class="dropdown-menu">
													<li><a class="dropdown-item" href="/WebASMServlet/page-change-password">Change password</a></li>
													<li><a class="dropdown-item" href="/WebASMServlet/page-favorite">My favorite</a></li>
													<c:if test="${sessionScope.user.admin}">
														<li><a class="dropdown-item" href="/WebASMServlet/admin-home">Management</a></li>
													</c:if>
													<li><hr class="dropdown-divider"></li>
													<li><a class="dropdown-item" href="/WebASMServlet/logoff">Log out</a></li>
												</ul>
											</div></li>
									</ul>
								</form>
							</c:otherwise>
						</c:choose>
					</div>
				</div>
			</nav>
		</div>
		
	</div>




