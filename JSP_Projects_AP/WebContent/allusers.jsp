<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2> Available Users List </h2>

<table border="1" cellpadding="5">
	<tr><td>Username</td><td>Password</td> <td>Email</td><td>Mobile No</td></tr>
	<c:forEach var="user"  items="${sessionScope.userList}">
		<tr><td>${user.getUsername()}</td><td>${user.getPassword()}</td> <td>${user.getEmail()}</td><td>${user.getMobileno()}</td></tr>		
	</c:forEach>
</table>		
</body>
</html>