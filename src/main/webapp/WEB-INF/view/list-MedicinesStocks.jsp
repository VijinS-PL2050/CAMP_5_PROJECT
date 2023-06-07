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

		<input type="button" value="Add Medicine"
			onclick="window.location.href='showFormAdd'; return false;" />
		<form action="search" method="post">
                    <input type="text" name ="searchName" placeholder="enter the medicine Name" >

                      <button type="submit">search</button>
               </form>
               

		<!-- Add our html table -->
		<table>
			<tr>
				<th>Medicine Id</th>
				<th>Medicine Name</th>
				<th>Company Name</th>
				<th>Generic Name</th>
				<th>Quantity</th>
				<th>Price</th>
			</tr>

			<!-- loop over and print our customers -->
			<c:forEach var="tempMedicine" items="${MedicinesStocks}">

				<!-- Construct an update link with customer id -->
				<c:url var="updateLink" value="/MedicinesStock/showFormUpdate">
					<c:param name="msId" value="${tempMedicine.msId }" />

				</c:url>
				<!-- Construct an delete link with customer id -->
				<c:url var="disableLink" value="/MedicinesStock/showFormDisable">
					<c:param name="msId" value="${tempMedicine.msId }" />
				</c:url>

				<!-- Construct an delete link with customer id -->
				<c:url var="deleteLink" value="/MedicinesStock/delete">
					<c:param name="msId" value="${tempMedicine.msId }" />
				</c:url>
				<tr>
					<td>${tempMedicine.medicineId }</td>
					<td>${tempMedicine.medicineName }</td>
					<td>${tempMedicine.companyName }</td>
					<td>${tempMedicine.genericName }</td>
					<td>${tempMedicine.quantity }</td>
					<td>${tempMedicine.price }</td>
					<td> 
					<a href="${updateLink }">Update</a> 
					<a	href="${deleteLink }">Delete</a>
					<a	href="${disableLink }">Disable</a></td>
			</c:forEach>
		</table>
			</div>
		<form></form>
		
					
		





	

</body>
</html>