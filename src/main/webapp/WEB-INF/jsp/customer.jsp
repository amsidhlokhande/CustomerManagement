<%@ include file="/WEB-INF/jsp/include.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Customer Management</title>
</head>
<body>
	<div align="center">
		<form:form action="customerAction" method="post"
			commandName="customer">
			<table>
				<tr>
					<td>Customer ID:</td>
					<td><form:input path="customerId" /></td>
				</tr>
				<tr>
					<td>Name</td>
					<td><form:input path="customerName" /></td>
				</tr>
				<tr>
					<td>Address</td>
					<td><form:input path="address" /></td>
				</tr>

				<tr>
					<td colspan="2"><input type="submit" name="actionName"
						value="Save" /> <input type="submit" name="actionName"
						value="Update" /> <input type="submit" name="actionName"
						value="Delete" /> <input type="submit" name="actionName"
						value="Search" /></td>
				</tr>
			</table>
		</form:form>
	</div>
	<div align="center">
		<c:if test="${not empty customerList}">
			<table border="2">
				<tr>
					<th>ID</th>
					<th>Name</th>
					<th>Address</th>
				</tr>
				<c:forEach items="${customerList}" var="customer">
					<tr>
						<td>${customer.customerId}</td>
						<td>${customer.customerName }</td>
						<td>${customer.address}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>
</body>
</html>