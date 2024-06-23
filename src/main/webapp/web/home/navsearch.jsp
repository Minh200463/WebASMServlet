<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<header>
	<nav class="navbar">
		<div class="container">
			<form class="d-flex mt-5 pt-5 mx-auto" role="search" method="POST">
				<input class="me-2 form-control" style="width: 500px;" type="search"
					name="input_search" placeholder="Enter name video" aria-label="Search" />
				<button class="btn btn-outline-dark text-dark" style="width: 150px;"
				formaction="/WebASMServlet/page-find-video"	type="submit">Search</button>
			</form>
		</div>
	</nav>
</header>