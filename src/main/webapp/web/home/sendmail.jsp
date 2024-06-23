<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!-- Contact 1 - Bootstrap Brain Component -->
<section class="bg-light py-3 py-md-5">
	<div class="container">
		<div class="row justify-content-md-center">
			<div class="col-12 col-md-10 col-lg-8 col-xl-7 col-xxl-6">
				<h2 class="mb-4 display-5 text-center fw-bold">SEND MAIL</h2>
				<hr class="w-50 mx-auto mb-5 mb-xl-9 border-dark-subtle">
			</div>
		</div>
	</div>

	<div class="container">
		<div class="row justify-content-lg-center">
			<div class="col-12 col-lg-9">
				<div class="bg-white border rounded shadow-sm overflow-hidden">

					<form action="" method="POST" enctype="multipart/form-data">
						<div class="row gy-4  p-4 p-xl-5">
						<div class="col-12">
								<c:if test="${not empty message }">
									<div class="text-success">${message }</div>
								</c:if>
								<c:if test="${not empty error }">
									<div class="text-danger">${error }</div>
								</c:if>
							</div>
							<div class="col-12  col-lg-6">
								<label for="fullname" class="form-label">Username<span
									class="text-danger">*</span></label> <input type="text"
									class="form-control" id="username" name="username"
									value="${sessionScope.user.username}" disabled>
							</div>
							<div class="col-12 col-lg-6">
								<label for="email" class="form-label">From <span
									class="text-danger">*</span></label>
								<div class="input-group">
									<span class="input-group-text"> <svg
											xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-envelope"
											viewBox="0 0 16 16">
                      <path
												d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z" />
                    </svg>
									</span> <input type="email" class="form-control" id="email"
										name="mail_from" value="${sessionScope.user.email }" disabled>
								</div>
							</div>
							<div class="col-12">
								<label for="email" class="form-label">To <span
									class="text-danger">*</span></label>
								<div class="input-group">
									<span class="input-group-text"> <svg
											xmlns="http://www.w3.org/2000/svg" width="16" height="16"
											fill="currentColor" class="bi bi-envelope"
											viewBox="0 0 16 16">
                      <path
												d="M0 4a2 2 0 0 1 2-2h12a2 2 0 0 1 2 2v8a2 2 0 0 1-2 2H2a2 2 0 0 1-2-2V4Zm2-1a1 1 0 0 0-1 1v.217l7 4.2 7-4.2V4a1 1 0 0 0-1-1H2Zm13 2.383-4.708 2.825L15 11.105V5.383Zm-.034 6.876-5.64-3.471L8 9.583l-1.326-.795-5.64 3.47A1 1 0 0 0 2 13h12a1 1 0 0 0 .966-.741ZM1 11.105l4.708-2.897L1 5.383v5.722Z" />
                    </svg>
									</span> <input type="email" class="form-control" id="email"
										name="mail_to" value="" required>
								</div>
							</div>
							<div class="col-12">
								<label for="message" class="form-label">Subject <span
									class="text-danger">*</span></label> <input type="text"
									class="form-control" id="subject" name="mail_subject" required></input>
							</div>
							<div class="col-12">
								<label for="message" class="form-label">Message <span
									class="text-danger">*</span></label>
								<textarea class="form-control" id="content" name="content"
									rows="3" required>${link }</textarea>
							</div>
							
							<div class="col-12">
								<div class="d-grid">
									<button class="btn btn-primary btn-lg" type="submit">Submit</button>
								</div>
							</div>
						</div>
					</form>

				</div>
			</div>
		</div>
	</div>
</section>