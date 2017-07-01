<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Register here</title>
</head>
<body>
<h1>Register Here</h1>
<form action="RegistrationController" method="post">
<table>
<tr><td>FirstName:</td><td><input type="text" placeholder="first Name" name="Firstname"></td></tr>
<tr><td>LastName:</td><td><input type="text" placeholder="last Name" name="Lastname"></td></tr>
<tr><td>Address:</td><td><input type="text" placeholder="Address" name="Address"></td></tr>
<tr><td>PhoneNumber:</td><td><input type="text" placeholder="Phone Number" name="PhoneNumber"></td></tr>
<tr><td>Personal Email:</td><td><input type="text" placeholder="Personal Email" name="Email"></td></tr>
<tr><td>UserName:</td><td><input type="text" placeholder="UserName" name="Username"></td></tr>
<tr><td>Password:</td><td><input type="password" placeholder="Password" name="Password"></td></tr>
<tr><td><input type="submit" value="Register"></td>
<td><input type="reset" value="Reset"></tr>
</table>
${Change}
</form>
</body>
</html>