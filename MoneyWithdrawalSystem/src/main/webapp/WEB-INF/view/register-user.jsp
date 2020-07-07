<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>Registration Page</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>User Registration Page</h2>
		</div>
	</div>
	<hr>
	<form:form action="accountGenerate" modelAttribute="user">
		<label>Name: </label><form:input path="name"/>
		<form:errors path="name" cssClass="error"/>
		<br><br>
		
		<label>Email ID: </label><form:input path="emailId"/>
		<form:errors path="emailId" cssClass="error"/>
		<br><br>
		
		<label>Mobile: </label><form:input path="mobile"/>
		<form:errors path="mobile" cssClass="error"/>
		<br><br>
		
		<label>Age: </label><form:input path="age"/>
		<br><br>
		
		<label>Gender: </label><br><br>
		
		<form:radiobutton path="gender" value="M" /> Male 
		<form:radiobutton path="gender" value="F" /> Female 
		<form:radiobutton path="gender" value="-" /> Do not want to disclose 

		<br><br>
		
		<label>Monthly Salary: </label><form:input path="monthlySal"/>
		<br><br>
		
		<input type="submit" value="Submit"/>
		</form:form>
	
	
		
		<p>
			<a href="${pageContext.request.contextPath}/MoneyWithdrawalApp/home">Back to Home</a>
		</p>
	
	


</body>
</html>