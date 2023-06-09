<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>patient-form</title>
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
		<h2 class="logo">
			Global Health <br> Hospitals
		</h2>
	</div>
	<div id="container">
		<h2>INSERT PATIENT RECORD</h2>
		<f:form action="insertPatientRecord" modelAttribute="patient"
			method="post">
			<f:hidden path="pId" />
			<f:hidden path="mrNo" />
			<fieldset>
				<c:if test="${patient.patientName == null}">
					<label>NAME :</label>
					<f:input path="patientName" placeholder="Enter first name"
						pattern="[A-Za-z][A-Za-z\s]{3,30}[A-Za-z]$" required="true" />
				</c:if>
				<c:if test="${not empty patient.patientName}">
					<label>NAME :</label>
					<f:input path="patientName" disabled="true" />
				</c:if>
			</fieldset>
			<fieldset>
				<label>PHONE :</label>
				<f:input path="patientPhone" />
			</fieldset>
			<fieldset>
				<label>ADDRESS :</label>
				<f:input path="patientAddress" />
			</fieldset>
			<fieldset>
				<c:if test="${patient.patientAge == 0}">
					<label>AGE :</label>
					<f:input type="number" path="patientAge" />
				</c:if>
				<c:if test="${patient.patientAge>0}">
					<label>AGE :</label>
					<f:input type="number" path="patientAge" disabled="true" />
				</c:if>
			</fieldset>
			<fieldset>
				<c:if test="${patient.patientGender == null}">
					<label>GENDER :</label>
					<f:select path="patientGender">
						<f:option value="MALE">MALE</f:option>
						<f:option value="FEMALE">FEMALE</f:option>
						<f:option value="OTHER">OTHER</f:option>
					</f:select>
				</c:if>
				<c:if test="${not empty patient.patientGender}">
					<label>GENDER :</label>
					<f:input path="patientGender" disabled="true" />
				</c:if>
			</fieldset>
			<fieldset>
				<c:if test="${patient.patientBlood == null}">
					<label>BLOOD GROUP :</label>
					<f:select path="patientBlood">
						<f:option value="O+">O+</f:option>
						<f:option value="O-">O-</f:option>
						<f:option value="A+">A+</f:option>
						<f:option value="A-">A-</f:option>
						<f:option value="B+">B+</f:option>
						<f:option value="B-">B-</f:option>
						<f:option value="AB+">AB+</f:option>
						<f:option value="AB-">AB-</f:option>

					</f:select>
				</c:if>
				<c:if test="${not empty patient.patientBlood}">
					<label>BLOOD GROUP :</label>
					<f:input path="patientBlood" disabled="true" />
				</c:if>
			</fieldset>
			<fieldset>
				<f:button>SUMIT</f:button>
			</fieldset>


		</f:form>

		<p>
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/patient/listPatientRecords">Back
				to List Patients</button>
		</p>
	</div>


</body>
</html>