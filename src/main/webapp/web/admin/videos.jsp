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
			</div>
			<!-- END FORM SEARCH -->
	</nav>
</div>
<div class="row">
	<div class="container">
		<h4
			class="border-bottom bg-secondary border-dark rounded-3 border-3 p-2 px-4 text-white">Edit
			or Add Video</h4>
		<div class="container">
			<form action="/WebASMServlet/admin-videos"
				enctype="multipart/form-data" method="POST">
				<div class="card">
					<div class="card-header bg-warning">
						<h5 class="fw-bold">Add or Edit</h5>
					</div>
					<div class="card-body">
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
						<div class="row">
							<div class=" col-12 mb-3">
								<label for="formGroupExampleInput" class="form-label h5">Tittle</label>
								<input type="text" class="form-control"
									id="formGroupExampleInput" name="tittle"
									placeholder="Enter tittle video" value="${vd.tittle }">
							</div>
							<div class="col-lg-6 mb-3">
								<label for="formGroupExampleInput2" class="form-label h5">Href</label>
								<input type="text" class="form-control" id="href" name="href"
									value="${vd.href }">
							</div>
							<div class="col-lg-6 mb-3">
								<label for="formGroupExampleInput3" class="form-label h5">Poster</label>
								<input type="file" class="form-control" id="poster"
									name="poster">
							</div>
							<div class="col-lg-6">
								<label for="formGroupExampleInput4" class="form-label h5">Description</label><br>
								<textarea name="description" id="description" cols="70%"
									rows="4">${vd.description }</textarea>
							</div>
							<div class="col-lg-6">
								<label for="formGroupExampleInput5" class="form-label h5">View
									count</label><br>
								<div class="preview text-center">
									<input type="text" class="form-control" id="viewcount"
										name="viewcount" value="${vd.views }">
								</div>
							</div>
							<div class="col-lg-6 d-flex">
								<div class="mx-3">
									<input type="radio" name="active" value="true"
										${vd.active ? "" : "checked" }>Active
								</div>
								<div class="">
									<input type="radio" name="active" value="false"
										${vd.active ? "checked" : "" }>Inactive
								</div>
							</div>
						</div>
					</div>
					<div class="card-footer text-center">
						<a type="button" class="btn btn-outline-dark btn-reset"
							href="/WebASMServlet/admin-video-reset">Reset</a>
						<button type="submit" class="btn btn-success btn-create"
							formaction="/WebASMServlet/admin-video-create">Create</button>
						<button type="submit" class="btn btn-info btn-update"
							formaction="/WebASMServlet/admin-video-update/?id=${vd.id }">Update</button>
						<button class="btn btn-warning" type="submit" id="liveToastBtn"
							formaction="/WebASMServlet/admin-video-delete/?id=${vd.id}">Delete</button>
					</div>
				</div>
			</form>

		</div>
	</div>
</div>