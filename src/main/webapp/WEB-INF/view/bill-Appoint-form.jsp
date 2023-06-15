<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Bill-REGISTERATION</title>
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
	padding: 100px;
	margin: 20px auto;
	max-width: 1000px;
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
}

label {
	display: flex;
	justify-content: flex-start;
	align-items: center;
	margin-bottom: 10px;
	color: white;
	width: 100%;
}

select, input[type="datetime-local"], input[type="submit"], input[type="text"],
	input[type="number"] {
	width: 100%;
	padding: 8px;
	border: 1px solid #000000;
	border-radius: 5px;
}

input[type="submit"] {
	width: 20%;
	padding: 8px;
	border: 1px solid #000000;
	border-radius: 5px;
}

input[type="button"] {
	margin-top: 10%;
	width: 20%;
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
		<h2>REGISTERATION BILL</h2>
		<div class="fieldset-container" style="margin-top: 10%">
			<fieldset>
				<label>BILL NO :<c:out
						value="${billAppoint.billAppoinmentNo}" /></label>
			</fieldset>
			<fieldset>
				<label style="padding-left: 200px">BILL DATE :<c:out
						value="${billAppoint.billDate}" /></label>
			</fieldset>
		</div>
		<div class="fieldset-container">
			<fieldset>
				<label>REG NO : <c:out value="${patientRecord.mrNo}" /></label> <label>NAME
					: <c:out value="${patientRecord.patientName}" />
				</label>
			</fieldset>
			<fieldset>
				<label style="padding-left: 200px">REG DATE :<c:out
						value="${patientRecord.registrationDate}" />
				</label> <label style="padding-left: 200px">PHONE NUMBER : <c:out
						value="${patientRecord.patientPhone}" /></label>
			</fieldset>
		</div>
		<div class="fieldset-container">
			<fieldset>
				<label>APPOINTMENT NO : <c:out
						value="${appointmentRecord.bookingNo}" /></label> <label>APPOINTMENT
					DATE : <c:out value="${appointmentRecord.appointmentDateTime}" />
				</label>
			</fieldset>
			<fieldset>
				<label style="padding-left: 200px"> </label> <label
					style="padding-left: 200px">APPOINTMENT VALIDITY : <c:out
						value="${appointmentRecord.appointmentValidity}" /></label>
			</fieldset>
		</div>
		<div class="fieldset-container">
			<fieldset>
				<label>DEPARTMENT : <c:out
						value="${department.departmentName}" /></label> <label>DOCTOR
					NAME : <c:out value="${doctor.doctorName}" />
				</label>
			</fieldset>
			<fieldset>
				<c:if test="${token.tId != null}">
					<label style="padding-left: 200px">TOKEN NO: <c:out
							value="${token.tokenNo}" /></label>
					<label style="padding-left: 200px"></label>
				</c:if>
			</fieldset>
		</div>
		<div class="fieldset-container">
			<fieldset>
				<label>CONSULTATION FEE :</label> <label>TOTAL BILL :</label>
			</fieldset>
			<fieldset>
				<label style="padding-left: 200px"><c:out
						value="${doctor.consultationFee}" /></label> <label
					style="padding-left: 200px"><c:out
						value="${billAppoint.billAmount}" /></label>
			</fieldset>
		</div>
		<input type="button" value="Print" class="btn-submit"
			onclick="print_current_page()" />
		<p>
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/patient/listPatientRecords'">Back
				To List Patients</button>
			<button onclick="goBack()">Go Back</button>
		</p>
	</div>
</body>
<script type="text/javascript">
	function print_current_page() {
		window.print();
	}
	function goBack() {
		window.history.go(-2);
	}
</script>
</html>