<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Index File Project</title>
</head>
<body>
<% if(session.getAttribute("id")!=null){
	response.sendRedirect("secondlogin.jsp");	
}		
%>


<!-- <div style="margin-left:1200px">
<form action="LogoutController" method="post">
<input type="submit" value="Logout">
</form>
</div>
 -->
<h1>Login Here</h1>
<form action="LoginController" method="post">
<table>
<tr><td>${Registered}</td></tr>
<tr><td>UserName:</td><td><input type="text" placeholder="UserName" name="Username"></td></tr>
<tr><td>Password:</td><td><input type="password" placeholder="Password" name="Password"></td></tr>
<tr><td><input type="submit" value="Login"></td></tr>
<tr><td>${LoginError}</td></tr>
</table>
</form>
<a href="Register.jsp">Register Here</a>
</body>
</html>