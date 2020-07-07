<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>Withdrawal Page</title>
	<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2>Money Withdrawal Form</h2>
		</div>
	</div>
	<hr>
	
	<form:form action="withdrawINR" modelAttribute="moneyWithdrawal">
		<label>Withdraw Amount: </label><form:input path="withdrawalAmount"/>
		<form:errors path="withdrawalAmount" cssClass="error"/>
		<br><br>
		
		<label>Choice of notes: </label>
		<form:input path="denomination"/>
		<form:errors path="denomination" cssClass="error"/>
		<br><br>
		
		
		<input type="submit" value="Withdraw"/>
	</form:form>
	<hr>
	<p><b>
	The balance amount : ${theAmount}</i> <br>
	no. of ${moneyWithdrawal.denomination} notes: ${theDenomination}</b></p>
	
		
		<p>
			<a href="${pageContext.request.contextPath}/MoneyWithdrawalApp/home">Back to Home</a>
		</p>
	

	
	<div id="wrapper">
			<i><u>Note</u>
			<ul>
				<li>Your MWL is 50% of your Monthly Salary i.e ${theMWL} for you. Please make sure the total amount withdrawn does not exceed this.</li>
			</ul>
			</i>
		</div>
	</div>
	
	
</body>
</html>