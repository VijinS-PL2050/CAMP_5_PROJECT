<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>appointment-form</title>
</head>
<body>
	<div id="container">
		<h2>INSERT PATIENT RECORD</h2>
		<f:form action="insertAppointment" modelAttribute="appointment"
			method="post">
			<f:hidden path="aId" />
			<f:hidden path="bookingNo" />
			<f:hidden path="patientRecords.pId" />
			<fieldset>
				<label>DEPARTMENT :<f:select path="doctorDepartment.dId"
						name="dropdownList" id="dropdownList">
						<option value="">-- Select an option --</option>
						<c:forEach items="${department}" var="dept">
							<option value="${dept.dId}">${dept.departmentId}${dept.departmentName}</option>
						</c:forEach>
					</f:select></label>
			</fieldset>

			<fieldset>
				<label>DOCTOR :<f:select path="doctorDetails.doId"
						name="dropdownListS" id="dropdownListS">
						<option value="">-- Select an option --</option>
						<c:forEach items="${doctor}" var="doc">
							<option value="${doc.doId}">${doc.doctorName}</option>
						</c:forEach>
					</f:select></label>

			</fieldset>
			<fieldset>
				<label>APPOINTMENT DATE :<f:input type="datetime-local" path="appointmentDateTime" /></label>

			</fieldset>

			<fieldset>
				<f:button>SUBMIT</f:button>
			</fieldset>


		</f:form>


	</div>
	<p>
		<a
			href="${pageContext.request.contextPath}/appointment/listAppointmentRecords">Back
			to List Appointment</a>
	</p>

</body>
</html>