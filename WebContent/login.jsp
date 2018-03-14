<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>PubHub Login</title>
</head>
<body bgcolor="#ccccccc">

	<h2 align="center">Login Page</h2>

<!--<form action="LoginServlet" method="post"> 

<form action="UserLogin" method="post">
<table align="center">
<tr>
<td>UserName:</td>
<td><input type="text" name="userName"/></td>
</tr>
<tr>
<td>Password:</td>
<td><input type="password" name="password"/></td>
</tr>
<tr>
<td><input type="submit" value="login"/></td>  
</tr>
 
<tr>
<td>New User?  <a href="register.jsp" style="margin-left:30px;">Register Here</a></td>
</tr>

</table>
</form>	

-->


<center>
	<h2>Please Enter Your username and password:</h2>
	<form method="POST" action="j_security_check">
		<table border=1>
			<tr><td>Username: </td><td><input type="text" name="j_username"/></td></tr>
			<tr><td>Password: </td><td><input type="password" name="j_password"/></td></tr>
			<tr><td><input type="submit" value="Login"/></td></tr>
		</table>
	</form>
	</center>


</body>

<jsp:include page="footer.jsp" />
</html>