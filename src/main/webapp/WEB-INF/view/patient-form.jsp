<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>patient-form</title>
</head>
<body>
	<div id="container">
		<h2>INSERT PATIENT RECORD</h2>
		<f:form action="insertPatientRecord" modelAttribute="patient"
			method="post">
			<f:hidden path="pId" />
			<f:hidden path="mrNo" />
			<fieldset>
				<c:if test="${patient.patientName == null}">
					<label>NAME :<f:input path="patientName" /></label>
				</c:if>
				<c:if test="${not empty patient.patientName}">
					<label>NAME :<f:input path="patientName" disabled="true" /></label>
				</c:if>
			</fieldset>
			<fieldset>
				<label>PHONE :<f:input path="patientPhone" /></label>
			</fieldset>
			<fieldset>
				<label>ADDRESS :<f:input path="patientAddress" /></label>
			</fieldset>
			<fieldset>
				<c:if test="${patient.patientAge == 0}">
					<label>AGE :<f:input type="number" path="patientAge" /></label>
				</c:if>
				<c:if test="${patient.patientAge>0}">
					<label>AGE :<f:input type="number" path="patientAge" disabled="true" /></label>
				</c:if>
			</fieldset>
			<fieldset>
				<c:if test="${patient.patientGender == null}">
					<label>GENDER :<f:select path="patientGender">
							<f:option value="MALE">MALE</f:option>
							<f:option value="FEMALE">FEMALE</f:option>
							<f:option value="OTHER">OTHER</f:option>
						</f:select></label>
				</c:if>
				<c:if test="${not empty patient.patientGender}">
					<label>GENDER :<f:input path="patientGender" disabled="true" /></label>
				</c:if>
			</fieldset>
			<fieldset>
			<c:if test="${patient.patientBlood == null}">
					<label>BLOOD GROUP :<f:select path="patientBlood">
						<f:option value="O+">O+</f:option>
						<f:option value="O-">O-</f:option>
						<f:option value="A+">A+</f:option>
						<f:option value="A-">A-</f:option>
						<f:option value="B+">B+</f:option>
						<f:option value="B-">B-</f:option>
						<f:option value="AB+">AB+</f:option>
						<f:option value="AB-">AB-</f:option>

					</f:select></label>
				</c:if>
				<c:if test="${not empty patient.patientBlood}">
					<label>BLOOD GROUP :<f:input path="patientBlood" disabled="true" /></label>
				</c:if>
			</fieldset>
			<fieldset>
				<f:button>SUMIT</f:button>
			</fieldset>


		</f:form>


	</div>
	<p>
		<a
			href="${pageContext.request.contextPath}/patient/listPatientRecords">Back
			to List Patients</a>
	</p>

</body>
</html>