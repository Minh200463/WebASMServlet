<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div class="row p-5">
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
			<svg class="bi flex-shrink-0 me-2" role="img" aria-label="Success:">
									<use xlink:href="#check-circle-fill" /></svg>
			<div>${message }</div>
		</div>
	</c:if>
	<c:if test="${not empty error }">
		<div class="alert alert-danger d-flex align-items-center" role="alert">
			<svg class="bi flex-shrink-0 me-2" role="img" aria-label="Danger:">
									<use xlink:href="#exclamation-triangle-fill" /></svg>
			<div>${error }</div>
		</div>
	</c:if>
	<div class="con-register d-flex justify-content-center mt-3">
		<form class="row g-3 bg-danger-subtle rounded-3 p-3" method="POST"
			style="width: 650px;">
			<h2 class="text-center fw-bold">Change Password</h2>
			<div class="col-md-12">
				<label for="validationDefaultUsername" class="form-label">Username</label>
				<div class="input-group">
					<span class="input-group-text" id="inputGroupPrepend2">
					<i class="bi bi-person-fill-check fs-4"></i></span> <input
						type="text" name="username" class="form-control fw-bold"
						id="validationDefaultUsername"
						aria-describedby="inputGroupPrepend2"
						value="${sessionScope.user.username}" disabled required>
				</div>
			</div>
			<div class="col-md-12">
				<label for="validationDefault02" class="form-label">Password
					Now</label> <input type="password" name="password_now" class="form-control"
					id="validationDefault02" required>
			</div>
			<div class="col-md-12">
				<label for="validationDefault02" class="form-label">Password
					New</label> <input type="password" name="password_new" class="form-control"
					id="validationDefault02" required>
			</div>
			<div class="col-md-12">
				<label for="validationDefault02" class="form-label">Repassword</label>
				<input type="password" name="repassword" class="form-control"
					id="validationDefault02" required>
			</div>
			<div class="d-grid gap-2">
				<button class="btn btn-primary" type="submit">Submit</button>
				<a class="btn btn-success" href="/WebASMServlet/homepage">Back</a>
			</div>
		</form>
	</div>
</div>