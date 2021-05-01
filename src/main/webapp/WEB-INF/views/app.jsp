<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Welcome To Spring Mvc</h1>

<% String name = (String)request.getAttribute("name"); %>

<% if(name!=null && !name.isEmpty()){ %>
<h3>name:<%= name %></h3>
  <%}%>

</body>
</html>