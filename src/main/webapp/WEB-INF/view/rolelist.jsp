<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link href='https://unpkg.com/css.gg@2.0.0/icons/css/search.css'
	rel='stylesheet'>



<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List RoleDetails</title>
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
	max-width: 1000px;
	color: #ffffff;
}

.button-container {
	margin-right: auto;
}

h2 {
	color: #191970;
	text-align: center;
}

input[type="button"] {
	width: 12%;
	padding: 5px;
	border: 1px solid #000000;
	border-radius: 5px;
	margin-bottom: 10px;
	margin-left: 85%;
	display: flex;
	justify-content: space-between;
	display: flex;
}

input[type="text"], input[type="submit"] {
	width: 30%;
	padding: 5px;
	border: 1px solid #000000;
	border-radius: 5px;
	margin-bottom: 10px;
}

input[type="button"]:hover, input[type="submit"]:hover {
	background-color: #45a049;
}

table {
	width: 100%;
	border-collapse: collapse;
	color: #ffffff;
}

th, td {
	padding: 8px;
	text-align: center;
	border-bottom: 1px solid #ffffff;
	word-break: break-all; /* Add this property */
}

tr:nth-child(even) {
	background-color: #808080;
}

tr:hover {
	background-color: #a9a9a9;
}

.dele {
	color: #000000
}

.updat {
	color: #7FFF00
}

fieldset {
	border: none;
}

a {
	color: #000000
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
	<h2>ROLE LIST</h2>
		<input type="button" value="AddRoleDetails"
			onclick="window.location.href='showFormrole'; return false;">

		<form action="searchByName" class="f1" method="get">
			
		</form>
		<!-- Add our html table -->
		<table>
			<tr>
				<th>ROLE ID</th>
				<th>ROLE NAME</th>
				<th>ACTION</th>
			</tr>



			<c:forEach var="temproleDetails" items="${roleDetails}">


				<c:url var="updateLink" value="/roledetails/showFormUpdate">
					<c:param name="rId" value="${temproleDetails.rId}" />
				</c:url>
				<c:url var="deleteLink" value="/roledetails/showFormDelete">
					<c:param name="rId" value="${temproleDetails.rId}" />
				</c:url>

				<c:url var="disableLink" value="/role/disable">
					<c:param name="rId" value="${temproleDetails.rId}" />
				</c:url>
				<tr>

					<td>${temproleDetails.roleId}</td>
					<td>${temproleDetails.roleName}</td>

					<td> <a
						href="${disableLink}"><i class="fa fa-trash-o"
							style="font-size: 28px; color: #000000"></i></a></td>


				</tr>

			</c:forEach>

		</table>
		<p>
			<button onclick="goBack()">Go Back</button>
		</p>

	</div>

</body>
<script>
	function goBack() {
		window.history.back();
	}
</script>
</html>