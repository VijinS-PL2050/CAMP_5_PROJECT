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

					<c:if test="${StaffDetails.staffname == null}">

						<label>STAFF NAME :</label>

						<f:input path="staffname" placeholder="Enter staffname name"
							pattern="[A-Za-z][A-Za-z\s]{3,30}[A-Za-z]$" required="true" />

					</c:if>
					<c:if test="${not empty StaffDetails.staffname}">
						<f:hidden path="staffname" />
						<label>STAFF NAME :</label>
						<f:input path="staffname" disabled="true" />
					</c:if>

				</fieldset>

				<fieldset>
					<c:if test="${StaffDetails.dateofbirth == null}">
						<label>DATE OF BIRTH:</label>
						<f:input type="date" path="dateofbirth" id="dateofbirth"
							placeholder="Enter date of birth" min="1963-01-01" max="2000-01-01" required="true" />
					</c:if>
					<c:if test="${not empty StaffDetails.dateofbirth}">
						<f:hidden path="dateofbirth" />
						<label>DATE OF BIRTH:</label>
						<f:input path="dateofbirth" disabled="true" />
					</c:if>
				</fieldset>
			</div>

			<div class="fieldset-container">
				<fieldset>
					<c:if test="${StaffDetails.gender == null}">
						<label>GENDER :</label>
						<f:select path="gender" name="dropdownList" id="dropdownList">
							<f:option value="">-- Select an option --</f:option>
							<f:option value="MALE">MALE</f:option>
							<f:option value="FEMALE">FEMALE</f:option>
							<f:option value="OTHER">OTHER</f:option>

						</f:select>
					</c:if>
					<c:if test="${not empty StaffDetails.gender}">
						<f:hidden path="gender" />
						<label>GENDER :</label>
						<f:input path="gender" disabled="true" />
					</c:if>

				</fieldset>

				<fieldset>

					<c:if test="${StaffDetails.bloodGroup == null}">
						<label>BLOOD GROUP :</label>
						<f:select path="bloodGroup" name="dropdownLists"
							id="dropdownLists">
							<f:option value="">-- Select an option --</f:option>
							<f:option value="O+">O+</f:option>
							<f:option value="O-">O-</f:option>
							<f:option value="A+">A+</f:option>
							<f:option value="A-">A-</f:option>
							<f:option value="B+">B+</f:option>
							<f:option value="B-">B-</f:option>
							<f:option value="AB+">AB+</f:option>
							<f:option value="AB-">AB-</f:option>
						</f:select>

					</c:if>

					<c:if test="${not empty StaffDetails.bloodGroup}">
						<f:hidden path="bloodGroup" />
						<label>BLOOD GROUP :</label>
						<f:input path="bloodGroup" disabled="true" />

					</c:if>

				</fieldset>
			</div>

			<div class="fieldset-container">

				<fieldset>

					<label for="phoneno">PHONE NO:</label>

					<f:input path="phoneno" id="phoneno" placeholder="Enter phoneNo"
						pattern="^(\+91[\-\s]?)?0?(91)?[789]\d{9}$" required="true" />

				</fieldset>
				<fieldset>
					<label for="address">ADDRESS:</label>
					<f:input path="address" id="address" />
				</fieldset>
			</div>

			<div class="fieldset-container">
				<fieldset>

					<c:if test="${StaffDetails.adharNo == null}">
						<label>AADHAAR NO:</label>
						<f:input path="adharNo" placeholder="Enter aadharNo "
							pattern="^[2-9]{1}[0-9]{3}\s[0-9]{4}\s[0-9]{4}$" required="true" />
					</c:if>
					<c:if test="${not empty StaffDetails.adharNo}">
						<f:hidden path="adharNo" />
						<label>AADHAAR NO:</label>
						<f:input path="adharNo" disabled="true" />
					</c:if>
				</fieldset>


				<fieldset>
					<c:if test="${StaffDetails.qualification == null}">
						<label>QUALIFICATION:</label>
						<f:select path="qualification" name="dropdownLists"
							id="dropdownLists">
							<f:option value="">-- Select an option --</f:option>
							<option value="PharmD">PharmD</option>
							<option value="Diploma In Pharmacy">Diploma In Pharmacy</option>
							<option value="B.Sc Medical Laboratory">B.Sc Medical
								Laboratory</option>
							<option value="Health Science">Health Science</option>
							<option value="BSC Nursing">BSC Nursing</option>
							<option value="BSC">BSC</option>
							<option value="B.com">B.com</option>
						</f:select>
					</c:if>
					<c:if test="${not empty StaffDetails.qualification}">
						<f:hidden path="qualification" />
						<label>QUALIFICATION:</label>
						<f:input path="qualification" disabled="true" />
					</c:if>
				</fieldset>
			</div>

			<div class="fieldset-container">
				<fieldset>
					<label for="email">EMAIL:</label>
					<f:input path="email" id="email" />
				</fieldset>
				<fieldset></fieldset>
			</div>
			<fieldset>

				<input type="submit" value="Save" class="btn-submit" />
			</fieldset>
		</f:form>
		<p>
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/staffDetails/list'">Back
				to List</button>
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
