<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list-patients</title>
<link rel="stylesheet" href="<%=request.getContextPath()%>/css/list.css">
<link href="https://fonts.googleapis.com/icon?family=Material+Icons"
	rel="stylesheet">
	<link href='https://unpkg.com/css.gg@2.0.0/icons/css/search.css' rel='stylesheet'>
	
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
	text-align: left;
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
a{
 color: #000000
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
		<h2>PATIENT RECORDS</h2>
		<input type="button" value="Add Patient"
			onclick="window.location.href='showFormForPatientRecord'; return false;">

		<form action="searchByName" class="f1" method="post">
			<fieldset>
				<input type="text" name="patientName" placeholder="Search Name / MR No">
				<button type="submit"><i class="fa fa-search" style="font-size: 18px"></i></button>
			</fieldset>
		</form>
		<table>
			<tr>
				<th>MR NO</th>
				<th>NAME</th>
				<th>PHONE</th>
				<th>ADDRESS</th>
				<th>AGE</th>
				<th>GENDER</th>
				<th>BLOOD</th>
				<th>REGISTRATION DATE</th>
				<th>VALIDITY DATE</th>
				<th>APPOINTMENT</th>
				<th>ACTION</th>
			</tr>

			<!-- loop over and print our customer -->
			<c:forEach var="tempPatient" items="${records}">
				<!-- Construct an update link with customer id -->
				<c:url var="updateLink" value="/patient/showFormForUpdate">
					<c:param name="patientId" value="${tempPatient.pId}" />
				</c:url>
				<c:url var="deleteLink" value="/patient/showFormForDelete">
					<c:param name="patientId" value="${tempPatient.pId}" />
				</c:url>
				<c:url var="appointmentLink"
					value="/appointment/showFormForAppointment">
					<c:param name="patientId" value="${tempPatient.pId}" />
				</c:url>
				<tr>
					<td>${tempPatient.mrNo}</td>
					<td>${tempPatient.patientName}</td>
					<td>${tempPatient.patientPhone}</td>
					<td>${tempPatient.patientAddress}</td>
					<td>${tempPatient.patientAge}</td>
					<td>${tempPatient.patientGender}</td>
					<td>${tempPatient.patientBlood}</td>
					<td>${tempPatient.registrationDate}</td>
					<td>${tempPatient.validityDate}</td>
					<td><a href="${appointmentLink}">Book Appointment</a></td>
					<td><a href="${updateLink}" class="updat"><i
							class="fa fa-edit" style="font-size: 28px; color: #F8F8FF"></i></a> <a
						href="${deleteLink}" class="dele"><i class="fa fa-trash-o" style="font-size:28px; color:#000000"></i></a></td>
				</tr>
			</c:forEach>
		</table>
		<button onclick="goBack()">Go Back</button>
	</div>
</body>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
</html>
