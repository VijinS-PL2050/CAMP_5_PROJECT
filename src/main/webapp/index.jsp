<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
  <script>
    function updateDateTime() {
      var now = new Date();
      var datetime = now.toLocaleString();
      document.getElementById("datetime").innerHTML = datetime;
    }
    setInterval(updateDateTime, 1000); // Update every second
  </script>
</head>

<body>
	<a href="login/user">LOGIN</a>
	<a
		href="${pageContext.request.contextPath}/patient/showFormForPatientRecord">ADD
		PATIENT</a>
	<!--  <a href="${pageContext.request.contextPath}/appointment/showFormForAppointment">ADD APPOINTMENT</a>-->
	<a href="${pageContext.request.contextPath}/patient/listPatientRecords">LIST
		PATIENT</a>
	<a
		href="${pageContext.request.contextPath}/appointment/listAppointmentRecords">LIST
		APPOINTMENT</a>
	<a href="${pageContext.request.contextPath}/token/listTokenRecords">LIST
		TOKEN</a>
		
		<h1>Live Datetime</h1>
  <p id="datetime"></p>
</body>
</html>