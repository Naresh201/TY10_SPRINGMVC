<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%  String msg  = (String)request.getAttribute("msg"); %>
    <% if(msg != null){ %>
    <h1><%= msg %></h1>
    <%} %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
<form action="./updateproduct" method="post">
<input type="number"  name="productid" required="required">
<input type="text"   name="productname"  >
<input type="number"   name="productprice" >
<input type="number"   name="quantity">
<input type="submit" value="Update Item">
</form>
</div>
</body>
</html>