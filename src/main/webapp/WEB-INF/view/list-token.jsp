<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list-token</title>
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
			width="200" alt="medical logo png" />
		</a>
		<h1 class="logo">
			Global Health <br> Hospitals
		</h1>
	</div>
	<div id="container">
		<h2>TOKEN RECORDS</h2>
		<input type="button" value="Add Patient"
			onclick="window.location.href='${pageContext.request.contextPath}/patient/showFormForPatientRecord'">

		<form action="searchByBookingT" class="f1" method="post">
			<fieldset>
				<input type="text" name="bookingNo" placeholder="Search Booking No">
				<button type="submit" class="b2">Search</button>
			</fieldset>
		</form>
		<form action="searchByToken" class="f1" method="post">
			<fieldset>
				<input type="text" name="tokenNo" placeholder="Search Token No">
				<button type="submit" class="b2">Search</button>
			</fieldset>
		</form>
		<!-- Add our html table -->
		<table>
			<tr>
				<th>MR NO</th>
				<th>NAME</th>
				<th>APPOINTMENT NO</th>
				<th>TOKEN NO</th>
				<th>TOKEN DATE TIME</th>
				<th>DEPARTMENT</th>
				<th>DOCTOR</th>
				<th>ACTION</th>
			</tr>

			<!-- loop over and print our customer -->

			<c:forEach var="tempToken" items="${tokenReports}">

				<!-- Construct an update link with customer id -->
				<c:url var="deleteLink" value="/token/showFormForTokenDelete">
					<c:param name="tokenId" value="${tempToken.tId}" />
				</c:url>

				<tr>
					<td>${tempToken.appointment.patientRecords.mrNo}</td>
					<td>${tempToken.appointment.patientRecords.patientName}</td>
					<td>${tempToken.appointment.bookingNo}</td>
					<td>${tempToken.tokenNo}</td>
					<td>${tempToken.tokenTime}</td>
					<td>${tempToken.appointment.doctorDepartment.departmentName}</td>
					<td>${tempToken.appointment.doctorDetails.doctorName}</td>
					<td><a href="${deleteLink }"><i class="fa fa-trash-o"
							style="font-size: 28px; color: #000000"></i></a></td>

				</tr>



			</c:forEach>



		</table>
		<p>
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/patient/listPatientRecords'">Back
				To List Patients</button>
			<button onclick="goBack()">Go Back</button>
		</p>

	</div>


</body>
<script type="text/javascript">
	function goBack() {
		window.history.back();
	}
</script>
</html>