<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Payment Receipt</title>
<style type="text/css">
	table { border: 0; }
	table td { padding: 5px; }
</style>
</head>
<body>
<div align="center">
	<h1>Payment Done. Thank you for purchasing our products</h1>
	<br/>
	<h2>Receipt Details:</h2>
	<table>
		<tr>
			<td><b>Company Name:</b></td>
			<td>${registerPaymentForm.recruiterModel.recruiter.companyName}</td>
		</tr>
		<tr>
			<td><b>Recruiter Name:</b></td>
			<td>${registerPaymentForm.recruiterModel.recruiter.recruiterName}</td>
		</tr>
		<tr>
			<td><b>Payer:</b></td>
			<td>${payer.firstName} ${payer.lastName}</td>	
		</tr>
		
		<tr>
			<td><b>Description:</b></td>
			<td>${transaction.description}</td>
		</tr>	
		<tr>
			<td><b>Subtotal:</b></td>
			<td>${transaction.amount.details.subtotal} USD</td>
		</tr>
		<tr>
			<td><b>Discount:</b></td>
			<td>${transaction.amount.details.shippingDiscount} USD</td>
		</tr>
		<tr>
			<td><b>Total:</b></td>
			<td>${transaction.amount.total} USD</td>
		</tr>
		<tr>
</tr>
				
	</table>
	<br>
	<div align="center">
	<form action="loginSuccessPath">
<input type="submit" value="Ok">
</form>	
</div>
</div>

</body>
</html>