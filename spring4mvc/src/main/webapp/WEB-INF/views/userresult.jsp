<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <h2>User Registration Result</h2>    
  	<table>        
  		<tr>            
  			<td>Name</td>            
  			<td>${user.firstName}</td>        
		</tr>        
		<tr>            
			<td>Last name</td>            
			<td>${user.lastName}</td>        
		</tr>        
		<tr>            
			<td>Password</td>            
			<td>${user.password}</td>        
		</tr>        
		<tr>            
			<td>Detail</td>            
			<td>${user.detail}</td>        
		</tr>        
		<tr>            
			<td>Birth Date</td>            
			<td>${user.birthdate}</td>        
		</tr>        
		<tr>
            <td>Gender</td>            
            <td>${user.gender}</td>        
        </tr>        
        <tr>            
        	<td>Country</td>            
        	<td>${user.country}</td>        
       	</tr>        
       	<tr>            
       		<td>Non-Smoking</td>            
       		<td>${user.hobbies}</td>        
   		</tr>    
       	<tr>            
       		<td>Phoneno</td>            
       		<td>${user.phoneno}</td>        
   		</tr>    
       	<tr>            
       		<td>Email</td>            
       		<td>${user.email}</td>        
   		</tr>    

	</table> 
</body>
</html>