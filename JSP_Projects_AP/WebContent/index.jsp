<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%-- JSP Comments not visible to client  --%>
	<!--  HTML comment visible to client -->
	
	<h2> Welcome to JSP Page</h2>
	<%!
		int num1 = 100;
		int num2 = 200;
		int total = 0;
	%>	
	
	<%
		total = num1 + num2;
		if(total>400) {
	%>
		<h2> Total is greater than 400</h2>
	<%			
		}
		else {
	%>		
			<h2> Total is less than 400 </h2>
	<%
		}
	%>
	
	<h2> Total is : <%=total %></h2>
	
</body>
</html>











