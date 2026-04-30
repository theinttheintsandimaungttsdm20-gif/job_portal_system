<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sform" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Review</title>
<style type="text/css">
	table { border: 0; }
	table td { padding: 5px; }
</style>
</head>
<body>
<div align="center">
	<h1>Please Review Before Paying</h1>
	<sform:form modelAttribute="paymentModel" action="execute_payment" method="post">
	<table>
		<sform:input type="text" path="frmPaymentId" value="${paymentId}" />
		<sform:input type="text" path="frmRecruiterId" value="${userLogin.loginId}"/>
		<sform:input type="text" path="frmPlan" value="${transaction.description}" />
		<sform:input type="text" path="frmAmount" value="${transaction.amount.total}" />
		<sform:input type="text" path="frmDiscount" value="${transaction.amount.details.shippingDiscount}"/>
	
		<tr>
			<td colspan="2"><b>Transaction Details:</b></td>
			<td>
				<input type="hidden" name="paymentId" value="${paymentId}" />
				<input type="hidden" name="PayerID" value="${payerId}" />
				
			</td>
		</tr>
		<tr>
			<td>Description:</td>
			<td>${transaction.description}</td>
		</tr>
		<tr>
			<td>Subtotal:</td>
			<td>${transaction.amount.details.subtotal} USD</td>
		</tr>
		<tr>
			<td>Discount:</td>
			<td>${transaction.amount.details.shippingDiscount} USD</td>
		</tr>
		<tr>
			<td>Total:</td>
			<td>${transaction.amount.total} USD</td>
		</tr>	
		<tr><td><br/></td></tr>
		<tr>
			<td colspan="3"><b>Payer Information:</b></td>
		</tr>
		<tr>
			<td>First Name:</td>
			<td>${payer.firstName}</td>
		</tr>
		<tr>
			<td>Last Name:</td>
			<td>${payer.lastName}</td>
		</tr>
		<tr>
			<td>Email:</td>
			<td>${payer.email}</td>
		</tr>
		<tr><td><br/></td></tr>
		<tr>
			<td colspan="2"><b>Shipping Address:</b></td>
		</tr>
		<tr>
			<td>Recipient Name:</td>
			<td>${shippingAddress.recipientName}</td>
		</tr>
		<tr>
			<td>Line 1:</td>
			<td>${shippingAddress.line1}</td>
		</tr>
		<tr>
			<td>City:</td>
			<td>${shippingAddress.city}</td>
		</tr>
		<tr>
			<td>State:</td>
			<td>${shippingAddress.state}</td>
		</tr>
		<tr>
			<td>Country Code:</td>
			<td>${shippingAddress.countryCode}</td>
		</tr>
		<tr>
			<td>Postal Code:</td>
			<td>${shippingAddress.postalCode}</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="submit" value="Pay Now" />
			</td>
		</tr>		
	</table>
</sform:form>
</div>
</body>
</html>