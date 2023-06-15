<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>CMS</title>
<style>
body {
	background-color: #DCDCDC;
	margin: 0;
	padding: 0;
	font-family: Arial, sans-serif;
}

.icon {
	display: flex;
	justify-content: flex-end;
	align-items: center;
	margin-top: 20px;
	margin-right: 170px;
}

.logo {
	color: #FF4500;
	text-align: center;
}

#container {
	background-color: #696969;
	border-radius: 5px;
	padding: 20px;
	margin: 20px auto;
	max-width: 800px;
	color: #000000;
}

h2 {
	color: #191970;
	text-align: center;
}

fieldset {
	border: none;
	margin-bottom: 20px;
}

.fieldset-container {
	display: flex;
	justify-content: space-between;
}

.fieldset-container fieldset {
	flex: 1;
	margin-right: 20px;
}

label {
	display: flex;
	justify-content: flex-start;
	align-items: center;
	margin-bottom: 10px;
	color: white;
	width: 50%;
}

select, input[type="datetime-local"], input[type="submit"], input[type="text"],
	input[type="number"], input[type="password"] {
	width: 100%;
	padding: 8px;
	border: 1px solid #000000;
	border-radius: 5px;
}

input[type="submit"] {
	width: 50%;
	padding: 8px;
	border: 1px solid #000000;
	border-radius: 5px;
}

.btn-submit {
	background-color: #45a049;
	color: #ffffff;
	border: none;
	border-radius: 5px;
	padding: 10px 20px;
	cursor: pointer;
	display: block;
	margin: 0 auto;
}

.btn-submit:hover {
	background-color: #4caf50;
}

.content {
	width: 800px;
	color: #373737;
	position: relative;
	padding: 10px 100px;
}

.content .par {
	padding-left: 20px;
	padding-top: 50px;
	font-family: Arial;
	letter-spacing: 1.2px;
	line-height: 30px;
}

.content h1 {
	font-family: 'Times New Roman';
	font-size: 50px;
	padding-left: 20px;
	margin-top: 9%;
	letter-spacing: 2px;
}

.content .cn {
	width: 160px;
	height: 40px;
	background: #ff7200;
	border: none;
	margin-bottom: 10px;
	margin-left: 20px;
	font-size: 18px;
	border-radius: 10px;
	cursor: pointer;
	transition: .2s ease;
}

.content .cn a {
	text-decoration: none;
	color: #000;
	transition: .3s ease;
}

.cn:hover {
	background-color: #fff;
}

.content span {
	color: #ff7200;
	font-size: 65px
}
</style>
<script>
	// Handle back button behavior
	if (window.history && window.history.pushState) {
		window.history.replaceState(null, null, window.location.href);
		window.history.pushState(null, null, window.location.href);
		window.onpopstate = function(event) {
			window.history.go(1);
		};
	}
	function logout() {
		// Perform logout action here (e.g., invalidate session or clear session attributes)
		// Redirect to the login page
		window.location.href = "${pageContext.request.contextPath}/login/logout";
	}
	document.addEventListener("DOMContentLoaded", function() {
		var errorMessage = "${errorMessage}";
		if (errorMessage) {
			alert(errorMessage);
		}
	});
</script>
</head>
<body>

	<c:if test="${errorMessage != null}">
		<div class="alert alert-danger">${errorMessage}</div>
	</c:if>
	<div class="icon">
		<a href="https://www.freepnglogos.com/pics/medical-logo-png"
			title="Image from freepnglogos.com"> <img
			src="https://www.freepnglogos.com/uploads/medical-logo-png-5.png"
			width="200" alt="medical logo png" /></a>
		<h1 class="logo">
			Global Health <br> Hospitals
		</h1>
	</div>
	<div class="fieldset-container">
		<div class="content">
			<h1>
				Committed to Caring <br> <span>Since 1926</span><br>
			</h1>
			<p class="par">
				Helping one person might not change the world,<br> but it could
				change the world for one person.
			</p>

		</div>
		<div id="container">
			<h2>LOGIN</h2>

			<f:form action="login/mapUser" modelAttribute="user" method="post">

				<fieldset>
					<label>USERNAME</label>
					<f:input path="userName" type="text" placeholder="Enter Username"
						required="true" />
				</fieldset>
				<fieldset>
					<label>PASSWORD</label>
					<f:input path="password" type="password"
						placeholder="Enter Password" required="true" />
				</fieldset>
				<fieldset>
					<input type="submit" value="LOGIN" class="btn-submit" />
				</fieldset>

			</f:form>
		</div>

	</div>
</body>
</html>

