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
		


</head>
 
<body>


<div id="wrapper">
	<div id="header">
		<h2>Customer Relationship Management-CRM</h2>
	</div>
</div>


 <div id="container">
 	<div id="content">
 	
 		<!-- Add a button to add customers -->
 		<input type= "button" value="Add Customer" 
 		onclick="window.location.href='showFormForAdd'; return false;"
 		class="add-button"
 		/>
 		
 		
 		<!-- Add a search button for customer -->
 		<table>
 			<tr>
 				<td>
 					<form:form action="search" method="POST">
 						Search Customer:<input type="text" name="theSearchName" />
 						<input type="submit" value="Search" class="add-button">
 					</form:form>
 				</td>
 				<td>
 					<button type="button" onclick="window.location.href='list'; return false;">Refresh</button>
 				</td>
 			</tr>
 		</table>
 			
 		<!-- Our table starts from here -->
		<table>
				<tr> 
					<th>ID</th>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Email</th>
					<th>Action</th>
				</tr>
			<c:forEach var="tempCust" items="${customers}">
				
				<!-- generate an updte link for each customer -->
				<c:url var="updateLink" value="/customer/showform">
				<c:param name="customerId" value="${tempCust.id}"></c:param>
				
				</c:url>
				
				<!-- generate an updte link for each customer -->
				<c:url var="deleteLink" value="/customer/delete">
				<c:param name="customerId" value="${tempCust.id}"></c:param>
				
				</c:url>
				<tr>
					<td>${tempCust.id}</td>
					<td>${tempCust.firstName}</td>
					<td>${tempCust.lastName}</td>
					<td>${tempCust.email}</td>
					<td>
						<a href="${updateLink}">Update</a>
						<a href="${deleteLink}"
						onclick="if(!(confirm('Are you Sure you want to delete this user?'))) return false">Delete</a>
					</td>
				</tr>
			</c:forEach>
		</table>

	</div>
</div>


${requestScope.message}
</body>
</html>