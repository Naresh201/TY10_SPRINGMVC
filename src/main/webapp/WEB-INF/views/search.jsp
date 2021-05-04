 <%@page import="java.util.List"%>
    <%@page import="com.te.springmvc.beans.Product"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
    
    <%    List<Product> infobeans = (List)request.getAttribute("infobeans"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
		if (infobeans != null) {
	%>
	<table>
		<tr>
			<th>ID</th>
			<th>Name</th>
			<th>DOB</th>
		</tr>
		<%
			for (Product bean : infobeans) {
		%>
		<tr>
			<td><%= bean.getProductid() %></td>
			<td><%= bean.getProductname()%></td>
			<td><%= bean.getProductprice() %></td>
			<td><%= bean.getQuantity() %></td>
		</tr>

	</table>

	<%
		}
	}
	%>





</body>
</html>