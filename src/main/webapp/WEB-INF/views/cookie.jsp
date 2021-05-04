<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% String msg1 = (String)request.getAttribute("msg1");
String value =(String) request.getAttribute("value"); %>

<% if(value !=null && !value.isEmpty()){ %>

<h1>the cookie value is <%= value  %></h1>
<%} %>

<h1>
<a href="./createcookies">create cookies</a>
</h1>
<h1>
<a href="./getcookies">get cookies</a>
</h1>

<% String msg = (String)request.getAttribute("msg");%>

<% if(msg !=null){ %>

<h1><%= msg  %></h1>
<%} %>
</body>
</html>