<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="f" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Save DoctorDetails Form</title>

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
		<h2 align=center>Add DoctorDetails</h2>
		<f:form action="saveDoctorDetails" modelAttribute="DoctorDetails"
			method="post" onsubmit="return validateForm()">
			<f:hidden path="doId" />
			<f:hidden path="doctorId" />
			<f:hidden path="user.uId" />

			<div class="fieldset-container">
				<fieldset>

					<c:if test="${DoctorDetails.doctorName == null}">

						<label>DOCTOR NAME :</label>

						<f:input path="doctorName" placeholder="Enter doctor name"
							pattern="[A-Za-z][A-Za-z\s]{3,30}[A-Za-z]$" required="true" />

					</c:if>
					<c:if test="${not empty DoctorDetails.doctorName}">
						<f:hidden path="doctorName" />
						<label>DOCTOR NAME :</label>
						<f:input path="doctorName" disabled="true" />
					</c:if>

				</fieldset>
				<fieldset>

					<c:if test="${DoctorDetails.dateOfBirth == null}">

						<label>DATE OF BIRTH:</label>

						<f:input type="date" path="dateOfBirth" id="dateOfBirth"
							placeholder="Enter date of birth" min="1960-01-01" max="1998-01-01"  required="true" />

					</c:if>
					<c:if test="${not empty DoctorDetails.dateOfBirth}">
						<f:hidden path="dateOfBirth" />
						<label>DATE OF BIRTH:</label>
						<f:input path="dateOfBirth" disabled="true" />
					</c:if>
				</fieldset>
			</div>

			<div class="fieldset-container">
				<fieldset>
					<c:if test="${DoctorDetails.gender == null}">
						<label>GENDER :</label>
						<f:select path="gender" name="dropdownList" id="dropdownList">
							<f:option value="">-- Select an option --</f:option>
							<f:option value="MALE">MALE</f:option>
							<f:option value="FEMALE">FEMALE</f:option>
							<f:option value="OTHER">OTHER</f:option>

						</f:select>
					</c:if>
					<c:if test="${not empty DoctorDetails.gender}">
						<f:hidden path="gender" />
						<label>GENDER :</label>
						<f:input path="gender" disabled="true" />
					</c:if>

				</fieldset>
				<fieldset>

					<c:if test="${DoctorDetails.bloodGroup == null}">
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

					<c:if test="${not empty DoctorDetails.bloodGroup}">
						<f:hidden path="bloodGroup" />
						<label>BLOOD GROUP :</label>
						<f:input path="bloodGroup" disabled="true" />

					</c:if>

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

					<c:if test="${DoctorDetails.adharNo == null}">
						<label>AADHAAR NO:</label>
						<f:input path="adharNo" placeholder="Enter aadharNo "
							pattern="^[2-9]{1}[0-9]{3}\s[0-9]{4}\s[0-9]{4}$" required="true" />
					</c:if>
					<c:if test="${not empty DoctorDetails.adharNo}">
						<f:hidden path="adharNo" />
						<label>AADHAAR NO:</label>
						<f:input path="adharNo" disabled="true" />
					</c:if>
				</fieldset>

				<fieldset>
					<c:if test="${DoctorDetails.qualification == null}">
						<label>QUALIFICATION:</label>
						<f:select path="qualification" name="dropdownLists"
							id="dropdownLists">
							<f:option value="">-- Select an option --</f:option>
							<option value="MBBS">MBBS</option>
							<option value="MS">MS</option>
							<option value="MD">MD</option>
							<option value="BAMS">BAMS</option>
							<option value="BHMS">BHMS</option>
							<option value="BPT">BPT</option>
						</f:select>
					</c:if>
					<c:if test="${not empty DoctorDetails.qualification}">
						<f:hidden path="qualification" />
						<label>QUALIFICATION:</label>
						<f:input path="qualification" disabled="true" />
					</c:if>
				</fieldset>
			</div>

			<div class="fieldset-container">
				<fieldset>



					<c:if test="${DoctorDetails.doctorDepartment == null}">
						<label>DEPARTMENT :</label>
						<f:select path="doctorDepartment.dId" id="doctorDepartment">
							<option value="">-- Select an option --</option>
							<c:forEach items="${department}" var="dept">
								<option value="${dept.dId}">${dept.departmentId}${dept.departmentName}</option>
							</c:forEach>
						</f:select>
					</c:if>
					<c:if
						test="${not empty DoctorDetails.doctorDepartment.departmentName}">
						<f:hidden path="doctorDepartment.dId" />
						<label>DEPARTMENT :</label>
						<f:input path="doctorDepartment.departmentName" disabled="true" />
					</c:if>
				</fieldset>

				<fieldset>
					<label for="email">EMAIL:</label>
					<f:input path="email" id="email" />
				</fieldset>
			</div>

			<div class="fieldset-container">

				<fieldset>
					<label for="consultationFee">CONSULTATION FEE:</label>
					<f:input path="consultationFee" min="300" max="1000" id="consultationFee" />
				</fieldset>
				<fieldset>
					<label for="noOfToken">TOKENS:</label>
					<f:input path="noOfToken" min="10" max="30" id="noOfToken" />
				</fieldset>
			</div>


			<input type="submit" value="Save" class="btn-submit" />
			<br>
		</f:form>
		<p>
			<button
				onclick="window.location.href='${pageContext.request.contextPath}/doctordetails/list'">Back
				to List</button>

			<button onclick="goBack()">Go Back</button>
		</p>

	</div>


</body>
<script>
	function validateForm() {
		var dropdown = document.getElementById("dropdownList");
		var selectedValue = dropdown.value;
		var dropdowns = document.getElementById("dropdownLists");
		var selectedValues = dropdowns.value;
		if (selectedValue === "") {
			alert("Please Select Gender from the dropdown.");
			return false; // Prevent form submission
		}
		if (selectedValues === "") {
			alert("Please Select Blood Group option from the dropdown.");
			return false; // Prevent form submission
		}
		// Additional validation logic if needed
		return true; // Allow form submission
	}
	function goBack() {
		window.history.back();
	}
</script>
</html>