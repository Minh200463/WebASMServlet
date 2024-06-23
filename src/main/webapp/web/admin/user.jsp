
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="row">
	<nav class="navbar navbar-expand-lg bg-body-tertiary">
		<div class="container-fluid">
			<!-- START FORM SEARCH -->
			<div class="col-lg-9 mx-3 d-inline-flex">
				<button class="btn btn-outline-dark" type="button"
					data-bs-toggle="collapse" data-bs-target="#collapseExample"
					aria-expanded="false" aria-controls="collapseExample">
					<i class="bi bi-list fs-3"></i>
				</button>
				<nav class="navbar mx-3">
					<form class="d-flex" role="search" method="POST">
						<input class="form-control me-2" type="search" name="input_search"
							placeholder="Search" aria-label="Search">
						<button class="btn btn-outline-success" type="submit"
						formaction="/WebASMServlet/admin-find-user">Search</button>
					</form>
				</nav>
			</div>
			<!-- END FORM SEARCH -->
	</nav>
</div>
<div class="row">
	<div class="container">
		<h4
			class="border-bottom bg-secondary border-dark rounded-3 border-3 p-2 px-4 text-white">Edition
			User</h4>
		<div class="container">
			<!-- edit user -->
			<form action="/WebASMServlet/admin-users" method="POST">
				<div class="card mt-5">
					<div class="card-header bg-warning">
						<svg xmlns="http://www.w3.org/2000/svg" class="d-none">
  <symbol id="check-circle-fill" viewBox="0 0 16 16">
    <path
								d="M16 8A8 8 0 1 1 0 8a8 8 0 0 1 16 0zm-3.97-3.03a.75.75 0 0 0-1.08.022L7.477 9.417 5.384 7.323a.75.75 0 0 0-1.06 1.06L6.97 11.03a.75.75 0 0 0 1.079-.02l3.992-4.99a.75.75 0 0 0-.01-1.05z" />
  </symbol>
  <symbol id="info-fill" viewBox="0 0 16 16">
    <path
								d="M8 16A8 8 0 1 0 8 0a8 8 0 0 0 0 16zm.93-9.412-1 4.705c-.07.34.029.533.304.533.194 0 .487-.07.686-.246l-.088.416c-.287.346-.92.598-1.465.598-.703 0-1.002-.422-.808-1.319l.738-3.468c.064-.293.006-.399-.287-.47l-.451-.081.082-.381 2.29-.287zM8 5.5a1 1 0 1 1 0-2 1 1 0 0 1 0 2z" />
  </symbol>
  <symbol id="exclamation-triangle-fill" viewBox="0 0 16 16">
    <path
								d="M8.982 1.566a1.13 1.13 0 0 0-1.96 0L.165 13.233c-.457.778.091 1.767.98 1.767h13.713c.889 0 1.438-.99.98-1.767L8.982 1.566zM8 5c.535 0 .954.462.9.995l-.35 3.507a.552.552 0 0 1-1.1 0L7.1 5.995A.905.905 0 0 1 8 5zm.002 6a1 1 0 1 1 0 2 1 1 0 0 1 0-2z" />
  </symbol>
</svg>
						<c:if test="${not empty message }">
							<div class="alert alert-success d-flex align-items-center"
								role="alert">
								<svg class="bi flex-shrink-0 me-2" role="img"
									aria-label="Success:">
								<use xlink:href="#check-circle-fill" /></svg>
								<div>${message }</div>
							</div>
						</c:if>
						<c:if test="${not empty error }">
							<div class="alert alert-danger d-flex align-items-center"
								role="alert">
								<svg class="bi flex-shrink-0 me-2" role="img"
									aria-label="Danger:">
								<use xlink:href="#exclamation-triangle-fill" /></svg>
								<div>${error }</div>
							</div>
						</c:if>
						<h5 class="fw-bold">Add or Edit</h5>
					</div>
					<div class="card-body">

						<div class="row g-3">
							<div class="col-lg-6">
								<label for="usernameinput" class="h5 p-0">Username</label> <input
									type="text" name="username" for="usernameinput"
									class="form-control" value="${us.username }">
							</div>
							<div class="col-lg-6">
								<label for="passwordinput" class="h5 p-0">Password</label> <input
									type="password" name="password" for="passwordinput"
									class="form-control" value="${us.password }">
							</div>
							<div class="col-lg-6">
								<label for="fullnameinput" class="h5 p-0">Role</label>
								<div class="d-flex">
									<div class="form-check">
										<input class="form-check-input" value="true" type="radio"
											name="admin" id="flexRadioDefault1"> <label
											class="form-check-label" for="flexRadioDefault1">
											Admin </label>
									</div>
									<div class="form-check mx-3">
										<input class="form-check-input" value="false" type="radio"
											name="admin" id="flexRadioDefault2" checked> <label
											class="form-check-label" for="flexRadioDefault2">
											User </label>
									</div>
								</div>
							</div>
							<div class="col-lg-6">
								<label for="emailinput" class="h5 p-0">Email</label> <input
									type="email" name="email" for="emailinput" class="form-control"
									value="${us.email }">
							</div>
						</div>
					</div>
					<div class="card-footer text-center">
						<button type="submit" class="btn btn-outline-dark btn-reset"
							formaction="/WebASMServlet/admin-reset">Reset</button>
						<button type="submit" class="btn btn-success btn-create"
							formaction="/WebASMServlet/admin-create">Create</button>
						<button type="submit" class="btn btn-info btn-update"
							formaction="/WebASMServlet/admin-update/?id=${us.id }">Update</button>
						<button type="submit" class="btn btn-danger btn-delete"
							formaction="/WebASMServlet/admin-delete/?id=${us.id }">Delete</button>
					</div>
				</div>

				<!-- list user -->
				<div class="card">
					<div class="card-header bg-warning">
						<h5 class="fw-bold">List Users</h5>
					</div>
					<form>
						<div class="card-body">
							<table class="table table-striped ">
								<thead>
									<tr>
										<th scope="col">ID</th>
										<th scope="col">Username</th>
										<th scope="col">Email</th>
										<th scope="col">Role</th>
										<th scope="col">Action</th>
									</tr>
								</thead>
								<tbody>

									<!-- user1 -->
									<c:forEach var="us" items="${user }">
										<tr>
											<th>${us.id}</th>
											<td>${us.username}</td>
											<td>${us.email}</td>
											<td>${us.admin ? "Admin" : "User"}</td>
											<td><a class="btn btn-primary"
												href="/WebASMServlet/admin-edit/?id=${us.id }">Edit</a>
												<button type="submit" class="btn btn-warning"
													formaction="/WebASMServlet/admin-delete/?id=${us.id }">
													Delete</button></td>
										</tr>
									</c:forEach>


								</tbody>
							</table>
						</div>
					</form>
					<div class="card-footer">
						<div class="box-pagination">
							<nav aria-label="Page navigation example">
								<ul class="pagination justify-content-center pt-3">
									<li class="page-item me-2">
										<button class="btn btn-outline-primary">
											<i class="bi bi-skip-backward-fill"></i> Previous</i>
										</button>
									</li>
									<li class="page-item">
										<button class="btn btn-outline-primary" href="#">
											Next <i class="bi bi-skip-forward-fill"></i>
										</button>
									</li>
								</ul>
							</nav>
						</div>
					</div>
				</div>



			</form>
		</div>
	</div>
</div>
