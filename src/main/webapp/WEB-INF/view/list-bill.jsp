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
<form action="searched" method="post">
                    <input type="text" name ="searchName" placeholder="enter the Patient Name" >

                      <button type="submit">search</button>
               </form>
              

<table>
			<tr>
			   <th>BillMedicineNO</th>
			   <th>BillDate</th>
			    <th>MedicinePrescriptionId</th>
			    <th>MRNo</th>
				<th>Patient Name</th>
				<th>Medicine Id Name</th>
				<th>Medicine Name</th>
				<th>Quantity</th>
				<th>Price</th>
				<th>Number Of Days</th>
				<th>Dosage </th>
				
	           
				
			</tr>

		<!-- loop over and print our customers -->
			<c:forEach var="tempprescription" items="${BillMedicines}">

				
				

				<tr>
				<td>${tempprescription.billMedicineNo}</td>
				<td>${tempprescription.billDate}</td>
				<td>${tempprescription.medicinePrescription.medicinePrescriptionId }</td>
			    <td>${tempprescription.medicinePrescription.diagnosis.tokenGenarator.appointment.patientRecords.mrNo }</td>
				<td>${tempprescription.medicinePrescription.diagnosis.tokenGenarator.appointment.patientRecords.patientName }</td>
				<td>${tempprescription.medicinePrescription.medicinesStock.medicineId }</td>
				<td>${tempprescription.medicinePrescription.medicinesStock.medicineName }</td>
				<td>${tempprescription.medicinePrescription.medicinesStock.quantity }</td>
				<td>${tempprescription.medicinePrescription.medicinesStock.price}</td>
				<td>${tempprescription.medicinePrescription.noOfDay }</td>
				<td>${tempprescription.medicinePrescription.dosage.dosage }</td>
				
				 <td> <a href="${pageContext.request.contextPath}/MedicinesStock/listbill">Billgenerate</a></td>	
				 
					
					
					

					
					
		</tr>



</c:forEach>
</table>

	</div>

</body>
</html>