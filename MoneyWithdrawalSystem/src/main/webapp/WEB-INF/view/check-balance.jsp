<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
<title>Debit Detail Page</title>
		<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Your Debit Details</h2>
		</div>
	</div>

	<hr>
	
	<div id="container">
	
		<div id="content">
		
			<!--  add our html table here -->
		
			<table>
				<tr>
					<th>Transaction Detail</th>
					<th>Debit Amount</th>
					<th>Final Balance</th>
				</tr>
				
				<!-- loop over and print our list -->
				<c:forEach var="tempLogs" items="${transactionLogs}">
				
					<tr>
						<td> ${tempLogs.details} </td>
						<td> ${tempLogs.balance} </td>
						<td> ${tempLogs.finalBalance} </td>
					</tr>
				
				</c:forEach>			
						
			</table>
			
	
		
		<p>
			<a href="${pageContext.request.contextPath}/MoneyWithdrawalApp/home">Back to Home</a>
		</p>
	
				
		</div>
	
	</div>
	
	

</body>
</html>