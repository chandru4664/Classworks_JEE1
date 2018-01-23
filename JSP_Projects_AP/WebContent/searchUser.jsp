<%@page import="com.htc.servlet.dto.UserDTO"%>
<%@page import="com.htc.servlet.service.UserService"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<jsp:useBean id="service" class="com.htc.servlet.service.UserService" scope="request"/>
	<%
		String username = request.getParameter("username");
		UserDTO user = service.searchUser(username);
		request.setAttribute("user", user);
		if(user!=null) {
	%>
	
	<table>
	<tr><td>Username</td> <td> <%=user.getUsername() %></td></tr>
	<tr><td>Password</td> <td> *******</td></tr>
	<tr><td>Email</td> <td> <%=user.getEmail()%></td></tr>
	<tr><td>Contactno</td> <td> <%=user.getMobileno() %></td></tr>
	</table>
	
	<%
		}
		else{
			out.println("<h2> User doesn't exist");
		}
	%>


</body>
</html>







