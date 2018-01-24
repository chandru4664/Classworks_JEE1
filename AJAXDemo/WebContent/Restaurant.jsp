<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Restaurant Process</title>
</head>
<body>
<jsp:useBean id="restImpl" class="com.htc.ajax.dao.RestaurantDAOImpl"></jsp:useBean>
<jsp:useBean id="rest" class="com.htc.ajax.dto.RestaurantDTO" >
	<jsp:setProperty property="*" name="rest"></jsp:setProperty>
</jsp:useBean>
<%
restImpl.insertData(rest);
%>
<jsp:forward page="Restaurant.html"></jsp:forward>
</body>
</html>