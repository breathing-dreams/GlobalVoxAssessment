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

	<div id="wrapper">
		<div id="header">
			<h2>Congratulations!</h2>
		</div>
	</div>
	<hr>
	
	<p>You have successfully registered with 
	<b>Account no. </b> ${user.accountId} and your <b>current balance</b> is <i>${user.monthlySal}</i> </p>
	<p>
			<a href="${pageContext.request.contextPath}/MoneyWithdrawalApp/home">Back to Home</a>
	</p>
	
	</div>
	
	

</body>
</html>