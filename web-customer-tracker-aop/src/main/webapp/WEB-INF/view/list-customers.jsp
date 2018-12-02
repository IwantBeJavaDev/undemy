<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List Customers</title>
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />
<!-- <link href="<spring:url value="/resources/css/style.css"/>" rel="stylesheet" />-->
</head>
<body>
	<div id="wrapper">
		<div id="header">
			<h1>CRM - Customer Relationship Manager</h1>
		</div>
	</div>
	
	<div id="container">
	
		<!-- put new button: Add customer -->
	
		<input type="button" value="Add Customer"
			onclick="window.location.href='showFormForAdd'; return false;" 
			class="add-button"	
		/>
		
		<form:form action="search" method="POST">
			Search customer: <input type="text" name="searchText"/>
			<input type="submit" value="Search" class="add-button"/>
		</form:form>
		
		<div id="content">
			<table>
				<tr>
					<th>First name</th>
					<th>Last name</th>
					<th>Email name</th>
					<th>Action</th>
				</tr>

				
				<!-- loop over and print our customer -->
				<c:forEach var="localCustomer" items="${customers}">
				
					<!-- Used to open link with value -->
				<c:url var="updateLink" value="/customer/showFormForUpdate">
					<c:param name="idCustomer" value="${localCustomer.idCustomer}"/>
				</c:url>
				
				
				<c:url var="deleteLink" value="/customer/delete">
					<c:param name="idCustomer" value="${localCustomer.idCustomer}"/>
				</c:url>
				
					<tr>
						<td>${localCustomer.firstName}</td>
						<td>${localCustomer.lastName}</td>
						<td>${localCustomer.email}</td>
						<td> 
							<a href="${updateLink}">Update</a>
							|
							<a href="${deleteLink}"
							onclick="if (!(confirm('Are you sure you want delete this customer'))) return false" >Delete</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>