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
	max-width: 1200px;
	height: 300px;
	color: #ffffff;
	position: relative;
}

.navbar {
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

	<div id="container">
		<h2>WELCOME RECEPTIONIST</h2>
		<div class="navbar">
			<a href="${pageContext.request.contextPath}/patient/showFormForPatientRecord">ADD PATIENT</a>
			<!--  <a href="${pageContext.request.contextPath}/appointment/showFormForAppointment">ADD APPOINTMENT</a>-->
			<a href="${pageContext.request.contextPath}/patient/listPatientRecords">LIST PATIENT</a>
			<a href="${pageContext.request.contextPath}/appointment/listAppointmentRecords">LIST APPOINTMENT</a>
			<a href="${pageContext.request.contextPath}/token/listTokenRecords">LIST TOKEN</a>
		</div>
	</div>
</body>
</html>
