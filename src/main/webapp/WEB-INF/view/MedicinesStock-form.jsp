<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>

<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
<meta charset="ISO-8859-1">
<title>save Medicine</title>
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
	max-width: 800px;
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

.fieldset-container {
	display: flex;
	justify-content: space-between;
}

.fieldset-container fieldset {
	flex: 1;
	margin-right: 20px;
}

label {
	display: flex;
	justify-content: flex-start;
	align-items: center;
	margin-bottom: 10px;
	color: white;
	width: 50%;
}

input[type="text"] {
	width: 100%;
	padding: 8px;
	border: 1px solid #000000;
	border-radius: 5px;
}

select, input[type="date"], input[type="submit"] {
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
		<h3></h3>
		<!-- JSTL tsg  library b-- form -->
		<f:form action="savemedicine" modelAttribute="MedicinesStocks"
			method="post">
			<!--  need to associate this data with customer id-->
			<f:hidden path="msId" />
			<f:hidden path="medicineId" />


			<div class="fieldset-container">


				<fieldset>
					<label>Medicine Name:</label>
					<f:input path="medicineName" />
				</fieldset>
				<fieldset>
					<label>Company Name:</label>
					<f:input path="companyName" />
				</fieldset>
			</div>

			<div class="fieldset-container">
				<fieldset>
					<label>Generic Name:</label>
					<f:input path="genericName" />
				</fieldset>

				<fieldset>
					<label>Medicine Quantity:</label>
					<f:input path="quantity" />
				</fieldset>
			</div>
			<div class="fieldset-container">
				<fieldset>
					<label>Medicine Price:</label>
					<f:input path="price" />
				</fieldset>
				<fieldset></fieldset>

			</div>
			<fieldset>

				<input type="submit" value="Save" class="btn-submit" />
			</fieldset>


		</f:form>
		<p>
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/MedicinesStock/list'">back
				to list</button>
			<button onclick="goBack()">Go Back</button>
		</p>



	</div>

</body>
<script>
	function goBack() {
		window.history.back();
	}
</script>
</html>
