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
<div>
<form action="./addproduct" method="post">

<input type="number"  name="productid" required="required">
<input type="text"   name="productname"  required="required">
<input type="number"   name="productprice" required="required">
<input type="number"   name="quantity" required="required">
<input type="submit" value="Add Item">
</form>
</div>
</body>
</html>