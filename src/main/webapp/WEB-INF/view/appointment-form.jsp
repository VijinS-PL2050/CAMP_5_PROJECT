<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	max-width: 600px;
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

select, input[type="datetime-local"] {
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
<script>
	// Handle back button behavior
	if (window.history && window.history.pushState) {
		window.history.replaceState(null, null, window.location.href);
		window.history.pushState(null, null, window.location.href);
		window.onpopstate = function(event) {
			window.history.go(1);
		};
	}
	function logout() {
		// Perform logout action here (e.g., invalidate session or clear session attributes)
		// Redirect to the login page
		window.location.href = "${pageContext.request.contextPath}/login/logout";
	}
	function updateDateTime() {
		var now = new Date();
		var datetime = now.toLocaleString();
		document.getElementById("datetime").innerHTML = datetime;
	}
	setInterval(updateDateTime, 1000); // Update every second
</script>
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
		<h2>APPOINTMENT</h2>
		<f:form action="insertAppointment" modelAttribute="appointment"
			method="post" onsubmit="return validateForm()">
			<f:hidden path="aId" />
			<f:hidden path="bookingNo" />
			<f:hidden path="patientRecords.pId" />
			<fieldset>
				<label>NAME : <c:out value="${sessionScope.name}" /></label> <label>REG
					NO : <c:out value="${sessionScope.mrno}" />
				</label> <label>REG DATE : <c:out value="${sessionScope.date}" /></label>
			</fieldset>
			<fieldset>
				<label>DEPARTMENT :</label>
				<f:select path="doctorDepartment.dId" name="dropdownList"
					id="dropdownList">
					<option value="">-- Select an option --</option>
					<c:forEach items="${department}" var="dept">
						<option value="${dept.dId}">||${dept.departmentId}||
							${dept.departmentName}</option>
					</c:forEach>
				</f:select>
			</fieldset>

			<fieldset>
				<label>DOCTOR :</label>
				<f:select path="doctorDetails.doId" name="dropdownList"
					id="dropdownList">
					<option value="">-- Select an option --</option>
					<c:forEach items="${doctor}" var="doc">
						<option value="${doc.doId}">${doc.doctorName}||TOKEN
							REMIAN :${doc.noOfToken} | |CONSULTATION FEE :
							${doc.consultationFee}||DEPART : ${doc.doctorDepartment.departmentName}</option>
					</c:forEach>
				</f:select>
			</fieldset>

			<fieldset>
				<label>APPOINTMENT DATE :</label>
				<f:input type="datetime-local" path="appointmentDateTime"
					min="2023-06-11T00:00" max="2023-06-18T00:00" />
			</fieldset>
			<input type="submit" value="SUBMIT" class="btn-submit" />
		</f:form>
		<p>
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/appointment/listAppointmentRecords'">Back
				to List Appointment</button>
			<button onclick="goBack()">Go Back</button>
		</p>
	</div>
</body>
<script>
	function validateForm() {
		var dropdown = document.getElementById("dropdownList");
		var selectedValue = dropdown.value;

		if (selectedValue === "") {
			alert("Please select an option from the dropdown.");
			return false; // Prevent form submission
		}

		// Additional validation logic if needed

		return true; // Allow form submission
	}
	function goBack() {
		window.history.back();
	}
</script>
</html>
