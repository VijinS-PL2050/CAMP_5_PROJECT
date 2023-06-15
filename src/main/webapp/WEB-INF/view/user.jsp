<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Form</title>
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
	margin-right: 100px;
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
	max-width: 400px;
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

label {
	display: flex;
	justify-content: flex-start;
	align-items: center;
	margin-bottom: 10px;
	color: white;
	width: 50%;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	border: 1px solid #000000;
	border-radius: 5px;
}

select, input[type="datetime-local"], input[type="submit"] {
	width: 100%;
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
</style>
</head>
<body>
	<div class="icon">

		<a href="https://www.freepnglogos.com/pics/medical-logo-png"
			title="Image from freepnglogos.com"> <img
			src="https://www.freepnglogos.com/uploads/medical-logo-png-5.png"
			width="200" alt="medical logo png" /></a>

		<h1 class="logo">

			Global Health <br> Hospitals

		</h1>

	</div>

	<div id="container">
		<h2 align=center>Add UserDetails</h2>
		<f:form action="saveuser" modelAttribute="UserDetails" method="post">
			<f:hidden path="uId" />
			<f:hidden path="userId" />
			<fieldset>
				<label >USERNAME :</label>

				<f:input path="userName" id="userName" />
			</fieldset>

			<fieldset>
				<label >PASSWORD :</label>
				<f:input path="password" id="password"/>
			</fieldset>

			<fieldset>
				<label >ROLE :</label>
				<f:select path="role.rId" id="role">
					<option value="">-- Select an option --</option>
					<c:forEach items="${listRole}" var="myrole">
						<option value="${myrole.rId}">${myrole.roleName}</option>
					</c:forEach>
				</f:select>
			</fieldset>
			<fieldset>
				<input type="submit" value="Save" class="btn-submit" />

			</fieldset>
		</f:form>
		<p>
			<button onclick="goBack()">Go Back</button>
		</p>
		<%-- <button

				onclick="window.location.href='${pageContext.request.contextPath}/index'">Back
				to Home</button>
		 --%>
	</div>
</body>
<script>
	function goBack() {
		window.history.back();
	}
</script>
</html>
