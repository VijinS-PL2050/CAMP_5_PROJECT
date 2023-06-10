<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save StaffDetails Form</title>
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

		<h1 class="logo">

			Global Health <br> Hospitals

		</h1>

	</div>

	<div id="container">
		<h2 align="center">Add StaffDetails</h2>
		<f:form action="saveStaffDetails" modelAttribute="StaffDetails"
			method="post">
			<f:hidden path="sId" />
			<f:hidden path="staffid" />
			<f:hidden path="user.uId" />

			<div class="fieldset-container">
				<fieldset>
					<label for="staffname">STAFF NAME:</label>
					<f:input path="staffname" id="staffname" />
				</fieldset>

				<fieldset>
					<label for="dateofbirth">DATE OF BIRTH:</label>
					<f:input type="date" path="dateofbirth" id="dateofbirth" />
				</fieldset>
			</div>

			<div class="fieldset-container">
				<fieldset>
					<label for="gender">GENDER:</label> <select id="gender"
						name="gender">
						<option value="MALE">MALE</option>
						<option value="FEMALE">FEMALE</option>
						<option value="OTHER">OTHER</option>
					</select>
				</fieldset>

				<fieldset>
					<label for="bloodGroup">BLOOD GROUP:</label> <select
						id="bloodGroup" name="bloodGroup">
						<option value="O+">O+</option>
						<option value="O-">O-</option>
						<option value="A+">A+</option>
						<option value="A-">A-</option>
						<option value="B+">B+</option>
						<option value="B-">B-</option>
						<option value="AB+">AB+</option>
						<option value="AB-">AB-</option>
					</select>
				</fieldset>
			</div>

			<div class="fieldset-container">
				<fieldset>
					<label for="phoneno">PHONE NO:</label>
					<f:input path="phoneno" id="phoneno" />
				</fieldset>
				<fieldset>
					<label for="address">ADDRESS:</label>
					<f:input path="address" id="address" />
				</fieldset>
			</div>

			<div class="fieldset-container">
				<fieldset>
					<label for="adharNo">ADHAR NO:</label>
					<f:input path="adharNo" id="adharNo" />
				</fieldset>
				<fieldset>
					<label for="qualification">QUALIFICATION:</label> <select
						id="qualification" name="qualification">
						<option value="PharmD">PharmD</option>
						<option value="Diploma In Pharmacy">Diploma In Pharmacy</option>
						<option value="B.Sc Medical Laboratory">B.Sc Medical
							Laboratory</option>
						<option value="Health Science">Health Science</option>
						<option value="BSC Nursing">BSC Nursing</option>
					</select>
				</fieldset>
			</div>

			<div class="fieldset-container">
				<fieldset>
					<label for="email">EMAIL:</label>
					<f:input path="email" id="email" />
				</fieldset>
				<fieldset>
				</fieldset>
			</div>
			<fieldset>

				<input type="submit" value="Save" class="btn-submit" />
			</fieldset>
		</f:form>
		<button

				onclick="window.location.href='${pageContext.request.contextPath}/staffDetails/list'">Back
				to List</button>
		
	</div>

</body>
</html>
