<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>save Medicine</title>
</head>
<body>
	<div id="container">
		<h3></h3>
		<!-- JSTL tsg  library b-- form -->
		<f:form action="savemedicine" modelAttribute="MedicinesStocks" method="post">
			<!--  need to associate this data with customer id-->
			<f:hidden path="msId" />
			<f:hidden path="medicineId" />
			<table>
				<tbody>
				
				
					
					
						
					<tr>
						<td><label>Medicine Name:</label></td>
						<td><f:input path="medicineName" /></td>
					</tr>
					<tr>
						<td><label>Company Name:</label></td>
						<td><f:input path="companyName" /></td>
					</tr>
					<tr>
						<td><label>Generic Name:</label></td>
						<td><f:input path="genericName" /></td>
					</tr>
					<tr>
					<td><label>Medicine Quantity:</label></td>
						<td><f:input path="quantity" /></td>
					</tr>
					<tr>
					<td><label>Medicine Price:</label></td>
						<td><f:input path="price" /></td>
					</tr>
					<tr>
						<td><label></label></td>
						<td><input type="submit" value="save" class="save"/></td>
					</tr>
				</tbody>

			</table>

		</f:form>
		<a href="${pageContext.request.contextPath}/MedicinesStock/list">back
			to list</a>


	</div>

</body>
</html>
