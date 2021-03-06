<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="mvc" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Register</title>
	<spring:url value="/resources/styles/style.css" var="mainCss" />
	<link rel="stylesheet" type="text/css" href="${mainCss}"/>

</head>
<body>
	<h2>User Registration Form</h2>
	<mvc:form  action="registerUser" modelAttribute="user"  method="post">    
		<table>        
			<tr>
			
				<td><mvc:label path="firstName">Name</mvc:label></td>
				<td><mvc:input path="firstName" cssErrorClass="fieldError"/></td>
				<td><mvc:errors path="firstName"  cssClass="errorMsg"/></td>
			</tr>
			<tr>
				<td><mvc:label path="lastName">Last Name</mvc:label></td>
				<td><mvc:input path="lastName" cssErrorClass="fieldError"/></td>
				<td><mvc:errors path="lastName" cssClass="errorMsg"/></td>
			</tr>
			<tr>
				<td><mvc:label path="password">Password</mvc:label></td>
				<td><mvc:password path="password" cssErrorClass="fieldError"/></td>
				<td><mvc:errors path="password" cssClass="errorMsg"/></td>
			</tr>
			<tr>
				<td><mvc:label path="detail">Detail</mvc:label></td>
				<td><mvc:textarea path="detail" cssErrorClass="fieldError"/></td>
				<td><mvc:errors path="detail" cssClass="errorMsg"/></td>
			</tr>
			<tr>
				<td><mvc:label path="birthdate">Birth Date</mvc:label></td>
				<td><mvc:input path="birthdate" cssErrorClass="fieldError"/></td>
				<td><mvc:errors path="birthdate" cssClass="errorMsg"/></td>
			</tr>
			<tr>
				<td><mvc:label path="gender">Gender</mvc:label></td>
				<td><mvc:radiobuttons  path="gender" items="${genders}" /></td>
				<td><mvc:errors path="gender" cssClass="errorMsg"/></td>
			</tr>
	        <tr>
	        	<td><mvc:label path="country">Country</mvc:label></td>
	        	<td><mvc:select path="country" items="${countryList}" cssErrorClass="fieldError"/></td>
	        	<td><mvc:errors path="country" cssClass="errorMsg"/></td>
        	</tr>
            <tr>
            	<td><mvc:label path="hobbies">Non Smoking</mvc:label></td>
            	<td><mvc:checkbox path="hobbies" value="Yes"/></td>
   	        </tr>
            <tr>
            	<td><mvc:label path="phoneno">Phoneno</mvc:label></td>
            	<td><mvc:input path="phoneno" cssErrorClass="fieldError"/></td>
            	<td><mvc:errors path="phoneno" cssClass="errorMsg"/></td>
   	        </tr>
            <tr>
            	<td><mvc:label path="email">Email</mvc:label></td>
            	<td><mvc:input path="email" cssErrorClass="fieldError"/></td>
            	<td><mvc:errors path="email" cssClass="errorMsg"/></td>
   	        </tr>

   	        <tr>
   	            <td colspan="2"><input type="submit" value="Submit" /></td>
            </tr>
        </table> 
    </mvc:form> 
</body>
</html>