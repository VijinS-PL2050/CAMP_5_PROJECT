<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
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
</body>
</html>