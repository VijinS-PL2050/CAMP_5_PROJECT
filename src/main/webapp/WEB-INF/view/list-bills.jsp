<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
<title>Insert title here</title>
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
>
</style>
<script>
	function displayLocalDateTime() {
		var currentDate = new Date();
		var formattedDate = currentDate.toLocaleDateString();
		var formattedTime = currentDate.toLocaleTimeString();

		var dateTimeElement = document.getElementById("localDateTime");
		dateTimeElement.textContent = formattedDate + " " + formattedTime;
	}

	// Call the function when the page finishes loading
	window.onload = displayLocalDateTime;
</script>



</head>
<body>

	<div class="icon">

		<a href="https://www.freepnglogos.com/pics/medical-logo-png"
			title="Image from freepnglogos.com"> <img
			src="https://www.freepnglogos.com/uploads/medical-logo-png-5.png"
			width="200" alt="medical logo png" /></a>

		<h2 class="logo">

			Global Health <br> Hospitals

		</h2>

	</div>
	


	<div id="container">


		<table>
			<tr>
			<tr>


				<th>BillNo</th>
				<th>Bill Date & Time</th>
				<th>Patient MRID</th>
				<th>Patient Name</th>
				<th>MedicineName</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Number Of Days</th>
				<th>Dosage</th>
				<th>Total</th>

			</tr>
			<c:set var="TotalBill" value="0" />
			<c:set var="billNo" value="BL1011" />
			<c:set var="billNo" value="${billNo}" />
			<!-- loop over and print our customers -->
			<c:forEach var="tempprescription" items="${MedicinePrescriptions}">
				<tr>
					<td><div id="billNo"><c:out value="${billNo}" /></div></td>


					
					<!-- Increment the billNo for the next iteration -->


					<th>
						<div id="localDateTime">
							<!-- Rest of the HTML code -->
						</div>
					</th>

					<td><c:out
							value="${tempprescription.diagnosis.tokenGenarator.appointment.patientRecords.mrNo }" /></td>
					<td><c:out
							value="${tempprescription.diagnosis.tokenGenarator.appointment.patientRecords.patientName }" /></td>
					<td><c:out
							value="${tempprescription.medicinesStock.medicineName }" /></td>
					<td><c:out value="${tempprescription.dosage.quantity }" /></td>
					<td><c:out value="${tempprescription.medicinesStock.price}" /></td>
					<td><c:out value="${tempprescription.noOfDay }" /></td>
					<td><c:out value="${tempprescription.dosage.dosage }" /></td>

					<td><c:set var="a"
							value="${tempprescription.dosage.quantity }" /> <c:set var="b"
							value="${tempprescription.medicinesStock.price}" /> <c:set
							var="Bill" value="${a * b}" /> <c:set var="TotalBill"
							value="${Bill + TotalBill}" /> <c:out value="${Bill}" /></td>
				</tr>
			</c:forEach>
			<tr>
				<th>Total</th>
				<th></th>
				<th>:</th>
				<th><c:out value="${TotalBill}" /></th>
			</tr>

		</table>



	</div>

</body>
</html>
