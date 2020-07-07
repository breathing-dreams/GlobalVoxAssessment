<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Error Page</title>
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div>
	
		<div id="wrapper">
		<div id="header">
			<h2>Error Page</h2>
		</div>
	</div>
	<hr>
		${Exception}
	</div>

	
	<p>
			<a href="${pageContext.request.contextPath}/MoneyWithdrawalApp/home">Back to Home</a>
			<a onclick="goBack()" href="">Go Back</a>
	</p>
	
	<script>
		function goBack() {
  			window.history.back();
		}
</script>

</body>
</html>