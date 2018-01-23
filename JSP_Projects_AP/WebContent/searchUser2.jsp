<%@page import="com.htc.servlet.dto.UserDTO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="service" class="com.htc.servlet.service.UserService" scope="request"/>
	<%
		String username = request.getParameter("username");
		UserDTO user = service.searchUser(username);
		request.setAttribute("user", user);
	%>
	
	<jsp:forward page="user.jsp" />
	
</body>
</html>