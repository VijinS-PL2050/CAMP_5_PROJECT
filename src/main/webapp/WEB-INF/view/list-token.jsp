<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list-token</title>
</head>
<body>
<div id="container">
		<input type="button" value="Add Patient"
			onclick="window.location.href='showFormForPatientRecord'; return false;">

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
					<td><a href="${deleteLink }">Delete</a></td>

				</tr>



			</c:forEach>



		</table>

	</div>
	<p>
		<a
			href="${pageContext.request.contextPath}/patient/listPatientRecords">Back
			to List Patients</a>
	</p>

</body>
</html>