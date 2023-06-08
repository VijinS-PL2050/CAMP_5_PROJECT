<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CMS</title>
</head>
<body>

	<div class="row m-auto d-flex justify-content-center">
		<h1 class=" p-4 mt-4 d-flex justify-content-center">GLHC</h1>

	</div>

	<div class="container bg-dark bg-gradient rounded w-50 pb-5 mt-5"
		id="loginContainer">
		<div class="row">
			<h3 class="text-center text-light p-4">Login</h3>
		</div>
		<div class="container rounded w-50">
			<f:form action="login/mapUser" modelAttribute="user" method="post">
				<div class="row bg-light rounded">
					<div class="col-3">
						<label class="form-label mt-1">Username</label>
					</div>
					<div class="col">
						<f:input path="userName" type="text" placeholder="Enter Username"
							class="form-control" required="true" />

					</div>
				</div>

				<div class="row bg-light mt-3 rounded">
					<div class="col-3">
						<label class="form-label mt-1">Password</label>
					</div>
					<div class="col">
						<f:input path="password" type="password"
							placeholder="Enter Password" class="form-control" required="true" />

					</div>

				</div>

				<!-- Submit -->
				<div class="row mt-4">
					<button class="btn btn-secondary" type="submit">
						<b>Login</b>
					</button>
				</div>
			</f:form>
		</div>
	</div>
</body>
</html>