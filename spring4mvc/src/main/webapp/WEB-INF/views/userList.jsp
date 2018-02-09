<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Register</title>
	<spring:url value="/resources/styles/style.css" var="mainCss" />
	<link rel="stylesheet" type="text/css" href="${mainCss}"/>
</head>
<body>
	<p align="center">Hello ${firstName} ${lastName} <br/> ${msg}</p>
		<table cellpadding="5" cellspacing="5" width="70%" align="center" border="1">
		<tr><td>First Name</td><td>Last Name</td><td>Birthdate</td><td>Email</td><td>Phoneno</td><td>Country</td><td colspan="2" align="center"> Actions</td></tr>        
			<c:forEach items="${users}" var="user">
				
				<c:url value="/editUser/${user.phoneno}" var="editURL" />
				
				<spring:url value="/deleteUser?email=${user.email}" var="deleteURL" />
				
				<tr>
					<td>${user.firstName }</td>
					<td>${user.lastName }</td>
					<td>${user.birthdate }</td>
					<td>${user.email }</td>
					<td>${user.phoneno }</td>
					<td>${user.country }</td>
					<td>
			  			
								<a href="${editURL}">Edit</a>
			 				
					</td>
					<td>
			 			  
								<a href="${deleteURL}">Delete</a>
							
					</td>
				</tr>	
			</c:forEach>
        </table> 
</body>
</html>