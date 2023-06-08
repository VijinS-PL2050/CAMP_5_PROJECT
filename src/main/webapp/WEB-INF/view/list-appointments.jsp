<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list-appointments</title>
</head>
<body>
	<div id="container">
		<input type="button" value="Add Patient"
			onclick="window.location.href='showFormForPatientRecord'; return false;">

		<form action="searchByBooking" class="f1" method="post">
			<fieldset>
				<input type="text" name="bookingNo" placeholder="Search Booking No">
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
				<th>APPOINTMENT NO</th>
				<th>APPOINTMENT DATE</th>
				<th>VALIDITY DATE</th>
				<th>DEPARTMENT</th>
				<th>DOCTOR</th>
			</tr>

			<!-- loop over and print our customer -->

			<c:forEach var="tempAppointment" items="${appointmentrecords}">

				<!-- Construct an update link with customer id -->
				<c:url var="updateLink" value="/appointment/showFormForAppointUpdate">
					<c:param name="appointId" value="${tempAppointment.aId}" />
				</c:url>
				<c:url var="deleteLink" value="/appointment/showFormForAppointDelete">
					<c:param name="appointId" value="${tempAppointment.aId}" />
				</c:url>
				
				<tr>
					<td>${tempAppointment.patientRecords.mrNo}</td>
					<td>${tempAppointment.patientRecords.patientName}</td>
					<td>${tempAppointment.bookingNo}</td>
					<td>${tempAppointment.appointmentDateTime}</td>
					<td>${tempAppointment.appointmentValidity}</td>
					<td>${tempAppointment.doctorDepartment.departmentName}</td>
					<td>${tempAppointment.doctorDetails.doctorName}</td>
					<td><a href="${updateLink }">Update</a> <a
						href="${deleteLink }">Delete</a></td>

				</tr>



			</c:forEach>



		</table>

	</div>
	<p>
		<a
			href="${pageContext.request.contextPath}/patient/listPatientRecords">Back
			to List Patients</a>
			<a
			href="${pageContext.request.contextPath}/token/listTokenRecords">Go
			to List Token</a>
	</p>

</body>
</html>