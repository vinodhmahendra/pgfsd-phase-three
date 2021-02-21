<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>


<html>
<head>
<title>New Customer</title>
</head>
<body>
	<div align="center">
		<h2>New Customer</h2>

		<form:form action="save" method="post" modelAttribute="customer">

			<table border="0" cellpadding="5">
				<tr>
					<td>Name :</td>
					<td><form:input path="name" /></td>
				</tr>

				<tr>
					<td>Phone :</td>
					<td><form:input path="phone" /></td>
				</tr>

				<tr>
					<td>Email :</td>
					<td><form:input path="email" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" value="save" /></td>
				</tr>
			</table>

		</form:form>
	</div>
</body>
</html>
