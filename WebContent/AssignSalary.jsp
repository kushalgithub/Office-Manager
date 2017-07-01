<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Salary</title>
</head>
<body>
<% if(session.getAttribute("id")==null){
	response.sendRedirect("index.jsp");	
}

else if(session.getAttribute("emptype").equals("manager")){
	response.sendRedirect("manager.jsp");	
}

else if(session.getAttribute("emptype").equals("employee")){
	response.sendRedirect("employee.jsp");	
}
else{
%>

<div style="margin-left:1200px">
<form action="LogoutController" method="post">
<input type="submit" value="Logout">
</form>
</div>

<form action="AssignSalaryController" method="post">
<table>
<tr><td>FirstName:${fn}</td></tr>
<tr><td>LastName:${ln}</td></tr>
<tr><td><input type="text" name="AssignSalary"></td></tr>
<tr><td><input type="hidden" value="<%=request.getAttribute("id")%>" name="empid"></td></tr>
<tr><td><input type="submit" value="AssignSalary"></td></tr>
</table>
</form>
<%} %>
</body>
</html>