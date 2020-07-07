<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div>
	
		<div id="wrapper">
		<div id="header">
			<h2>The Money WithDrawal Home Page</h2>
		</div>
	</div>
	<hr>
		<hr>
		<a href="register">Option 1: Register a user</a>
		<br><br>
		<a href="withdrawForm">Option 2: Withdraw INR</a>
		<br><br>
		<a href="withdrawInternationalForm">Option 3: International currency withdrawal</a>
		<br><br>
		<a href="checkBalance">Option 4:  Check Balance</a>
	</div>

	

</body>
</html>