<%@page import="com.htc.servlet.dto.UserDTO"%>
<%@page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h2> User Information </h2>
<%
	System.out.println(application.getRealPath("/"));
	UserDTO user = (UserDTO) request.getAttribute("user");
%>
	<c:choose>
		<c:when test="${user != null }">   <!-- Expression Language -->
			<table>
				<tr><td>Username</td> <td> <%=user.getUsername() %></td></tr>
				<tr><td>Password</td> <td> *******</td></tr>
				<tr><td>Email</td> <td> <%=user.getEmail()%></td></tr>
				<tr><td>Contactno</td> <td> <%=user.getMobileno() %></td></tr>
			</table>
		</c:when>
		<c:otherwise>
			<h2> User doesn't exist</h2>
		</c:otherwise>
	</c:choose>
	
<hr width="600px"/>
	<h2> Compnay Name : <%=application.getInitParameter("organization") %>
</body>
</html>












