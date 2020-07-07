<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<title>International currency withdrawal</title>
<link type="text/css"
		  rel="stylesheet"
		  href="${pageContext.request.contextPath}/resources/css/style.css" />
</head>
<body>

	<div id="wrapper">
		<div id="header">
			<h2> International currency withdrawal</h2>
		</div>
	</div>
	<hr>
	
	<form:form action="withdrawInternational" modelAttribute="internationalWithdrawal">
		<label>Select Currency: </label>
		
		<form:select path="currency">			
			<form:option value="-1" label="--Please Select"/>		
			<form:options items="${internationalWithdrawal.currencyOptions}"/>
		</form:select>
		<br><br>
		
		<label>Enter Amount to be Withdrawn: </label>
		<form:input path="withdrawAmount"/>
		<form:errors path="withdrawAmount" cssClass="error"/>
		<br><br>
		
		<label>Select Note choice: </label>
		<form:input path="noteChoice"/>		
		<br><br>
		<input type="submit" value="Submit"/>	
		<br><br>
	</form:form>
	<hr>
	<p><b>
	The balance amount : ${theBalanceAmount}</i> <br>
	Total amount deducted : ${theTotalWithdraw}</b></p>
	
	
	<a href="${pageContext.request.contextPath}/MoneyWithdrawalApp/home">Back to Home</a>
	<br><br>
	<div id="wrapper">
			<i><u>Note</u>
			<ul>
				<li> For each currency the choice of notes are as below :<br>
					 USD : 10,50,100,500 / GBP : 20,50,500,1000 / AUD : 100,500,1000</li>
			</ul>
			</i>
		</div>
	</div>
	
	
</body>
</html>