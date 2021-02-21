<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
	<title>Customer Manager</title>
</head>
<body>
	<div align="center">
		<h2>Customer Manager</h2>
		<h3><a href="/customer-service-web/new">New Customer</a></h3>
		<table border="1" cellpadding="5">
			<tr>
				<th> ID </th>
				<th> Name </th>
				<th>E-mail</th>
				<th>Phone</th>
				<th>Action</th>
			</tr>
		
		<c:forEach items="${customers}" var="customer">
			<tr>
			<td>${customer.id}</td>
			<td>${customer.name}</td>
			<td>${customer.email}</td>
			<td>${customer.phone}</td>
			
			<td>
				<a href="/customer-service-web/edit?id=${customer.id}">Edit</a>
				&nbsp;&nbsp;&nbsp;&nbsp;
				<a href="/customer-service-web/delete?id=${customer.id}">Delete</a>
			</td>
			</tr>
		</c:forEach>
			
		</table>
	</div>
</body>
</html>