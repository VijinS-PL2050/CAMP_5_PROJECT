<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="java.util.List"%>
<%@ page import="com.global.entity.DoctorDetails"%>
<%@ page
	import="com.global.receptionist.service.IDoctorAndDepartmentService"%>
<%@ page
	import="com.global.receptionist.repository.DoctorAndDepartmentRepo"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>appointment-form</title>
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

<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>







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
		<h2>APPOINTMENT</h2>
		<f:form action="insertAppointment" modelAttribute="appointment"
			method="post">
			<f:hidden path="aId" />
			<f:hidden path="bookingNo" />
			<f:hidden path="patientRecords.pId" />





			<fieldset>
				<label>DEPARTMENT:</label>
				<f:select path="doctorDepartment.dId" name="departmentDropdown"
					id="departmentDropdown">
					<option value="">-- Select an option --</option>
					<c:forEach items="${department}" var="dept">
						<option value="${dept.dId}">${dept.departmentId}
							${dept.departmentName}</option>
					</c:forEach>
				</f:select>
			</fieldset>

			<fieldset>
				<label>DOCTOR:</label> <select name="doctorDropdown"
					id="doctorDropdown">
					<option value="">-- Select an option --</option>
					<%
					String selectedDepartment = request.getParameter("departmentDropdown");
					if (selectedDepartment != null && !selectedDepartment.isEmpty()) {
						int departmentId = Integer.parseInt(selectedDepartment);
						DoctorAndDepartmentRepo doctorAndDepartmentService = new DoctorAndDepartmentRepo();
						List<DoctorDetails> doctors = doctorAndDepartmentService.getAllDoctorDetailss(departmentId);
						for (DoctorDetails doc : doctors) {
					%>
					<option value="<%=doc.getDoId()%>"><%=doc.getDoctorName()%></option>
					<%
					}
					}
					%>
				</select>
			</fieldset>





			<fieldset>
				<label>APPOINTMENT DATE :</label>
				<f:input type="datetime-local" path="appointmentDateTime" />
			</fieldset>

			<fieldset>
				<input type="submit" value="SUBMIT" class="btn-submit" />
			</fieldset>
		</f:form>
		<p>
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/appointment/listAppointmentRecords'">Back
				to List Appointment</button>
		</p>
	</div>



</body>
</html>
