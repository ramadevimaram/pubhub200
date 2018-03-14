<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<html>
<head>
<title>Registration Form</title>
</head> 
<body>
<c:if test="${errMsg != null}">
	<p> ${errMsg}</p>
</c:if>
<h3 align="center">Registration Form</h3>
<form action="Register" method="POST">
<table align="center" cellpadding = "10">
<tr>
<td>First Name</td>
<td><input type="text" name="firstName" maxlength="30"/>

</td>
</tr>

<tr>
<td>Last Name</td>
<td><input type="text" name="lastName" maxlength="30"/>

</td>
</tr>

<tr>
<td>UserName</td>
<td><input type="text" name="userName" minlength="8" />
</td>
</tr>

<tr>
<td>Email</td>
<td><input type="text" name="email" maxlength="100" /></td>
</tr>

<tr>
<td>Address</td>
<td><input type="text" name="address" maxlength="500" /></td>
</tr>

<tr>
<td>Password</td>
<td><input type="password" name="password" minlength="8" /></td>
</tr>
<tr>
<td colspan="2" align="center">
<input type="submit" value="Submit">
<input type="reset" value="Reset">
</td>
</tr>
</table>
</form>
</body>
</html>
