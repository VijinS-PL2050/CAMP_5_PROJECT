<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list-patients</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">

<link href='https://unpkg.com/css.gg@2.0.0/icons/css/search.css'
	rel='stylesheet'>

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

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

.log {
	display: flex;
	justify-content: flex-end;
	align-items: center;
	margin-top: 20px;
	margin-right: 170px;
}

.tim {
	margin-left: 85%;
}

#container {
	background-color: #696969;
	border-radius: 5px;
	padding: 20px;
	margin: 20px auto;
	max-width: 1200px;
	height: 400px;
	color: #ffffff;
	position: relative;
}

.navbar {
	top: 110px;
	position: absolute;
	left: 100px;
	display: flex;
	flex-direction: column;
}

.navbar a {
	width: 100%;
	padding: 10px;
	background-color: #191970;
	color: #ffffff;
	text-decoration: none;
	border-radius: 5px;
	margin-bottom: 10px;
	text-align: center;
}

.navbar a:hover {
	background-color: #CCCCFF;
	color: #0C090A;
}

h2 {
	color: #FFFFFF;
	text-align: center;
}

fieldset {
	border: none;
}

a {
	color: #000000;
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
	function updateDateTime() {
		var now = new Date();
		var datetime = now.toLocaleString();
		document.getElementById("datetime").innerHTML = datetime;
	}
	setInterval(updateDateTime, 1000); // Update every second
</script>

</head>

<body>

	<div class="icon">

		<a href="https://www.freepnglogos.com/pics/medical-logo-png"
			title="Image from freepnglogos.com"> <img
			src="https://www.freepnglogos.com/uploads/medical-logo-png-5.png"
			width="200" alt="medical logo png" />

		</a>

		<h1 class="logo">

			Global Health <br> Hospitals

		</h1>

	</div>
	<div class="log">
		<a href="javascript:void(0);" onclick="logout();"><span
			class="glyphicon glyphicon-log-out"
			style="font-size: 20px; color: black">Logout</span></a>
	</div>



	<div id="container">
		<div class="tim">
			<h5><%=session.getAttribute("username")%></h5>
			<h6 id="datetime"></h6>
		</div>

		<h2 style="margin-top: -50px">
			<strong>WELCOME </strong>
		</h2>

		<div class="navbar">

			<a
				href="${pageContext.request.contextPath}/MedicinesStock/showFormAdd">ADD
				MEDICINE STOCK</a> <a
				href="${pageContext.request.contextPath}/MedicinesStock/list">LIST
				MEDICINE STOCK</a> <a
				href="${pageContext.request.contextPath}/MedicinesStock/listveiw">MEDICINE
				PRESCRIPTION</a>

		</div>

	</div>

</body>

</html>




