<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list-patients</title>
</head>
<body>

<div id="container">
		<input type="button" value="Add Patient"
			onclick="window.location.href='showFormForPatientRecord'; return false;">

		<form action="searchByName" class="f1" method="post">
			<fieldset>
				<input type="text" name="patientName" placeholder="Search Name">
				<button type="submit" class="b2">Search</button>
			</fieldset>
		</form>
		<form action="searchByMRNo" class="f1" method="post">
			<fieldset>
				<input type="text" name="patientMRNo" placeholder="Search MR NO">
				<button type="submit" class="b2">Search</button>
			</fieldset>
		</form>
		<!-- Add our html table -->
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
				<c:url var="appointmentLink" value="/appointment/showFormForAppointment">
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
					<td><a href="${appointmentLink}">Book Appointment</a> </td>					
					<td><a href="${updateLink}">Update</a> <a
						href="${deleteLink}">Delete</a></td>

				</tr>



			</c:forEach>



		</table>

	</div>

</body>
</html>