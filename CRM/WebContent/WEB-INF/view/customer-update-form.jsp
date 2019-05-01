<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix ="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<title>All Customers</title>

<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/style.css" />
		
<link type="text/css"
		rel="stylesheet"
		href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />

</head>
 
<body>


<div id="wrapper">
	<div id="header">
		<h2>Customer Updation Form.....</h2>
	</div>
</div>

<div>
	<form:form action="updatecustomer" modelAttribute="customer" method="POST">
		<form:hidden path="id"/>
		<table>
			<tr>
				<td><label>First Name: </label></td>	
				<td><form:input path="firstName"/></td>
			</tr>
			<tr>
				<td><label>Last Name:</label></td>	
				<td><form:input path="lastName"/></td>
			</tr>
			<tr>
				<td><label>Email: </label></td>	
				<td><form:input path="email"/></td>
			</tr>
			<tr>
				<td><label></label></td>	
				<td><input type="submit" value="Submit"  class="save"/></td>
			</tr>
		</table>
		
		<div style="clear;both">
			<p>
				<a href="${pageContext.request.contextPath}/customer/list">Back to List</a>
			</p>
		
		</div>
		
	</form:form>
	
	
</div>
</body>
</html>