<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div id="container">
<form action="searchss" method="post">
                    <input type="text" name ="searchName" placeholder="enter the Patient Name" >

                      <button type="submit">search</button>
               </form>
               
<table>
			<tr>
				<th>Medicine Prescription Id </th>
				<th>Doctor Name</th>
				<th>mrNo</th>
				<th>Patient Name</th>
			</tr>

		<!-- loop over and print our customers -->
			<c:forEach var="tempprescription" items="${MedicinePrescriptions}">

				
				

				<tr>
					<td>${tempprescription.medicinePrescriptionId }</td>
					<td>${tempprescription.diagnosis.tokenGenarator.appointment.doctorDetails.doctorName }</td>
				    <td>${tempprescription.diagnosis.tokenGenarator.appointment.patientRecords.mrNo }</td>
					<td>${tempprescription.diagnosis.tokenGenarator.appointment.patientRecords.patientName }</td>
				  
					
					<td> 
					
                       <a href="${pageContext.request.contextPath}/MedicinesStock/listnew">View</a>
			
                    </td>


</c:forEach>
</table>

	</div>

</body>
</html>