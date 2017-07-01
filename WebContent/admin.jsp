<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<% if(session.getAttribute("id")==null){
	response.sendRedirect("index.jsp");	
}

else if(session.getAttribute("emptype").equals("manager")){
	response.sendRedirect("manager.jsp");	
}

else if(session.getAttribute("emptype").equals("employee")){
	response.sendRedirect("employee.jsp");	
}

%>

<body>
<div style="margin-left:1200px">
<form action="LogoutController" method="post">
<input type="submit" value="Logout">
</form>
</div>
<h1>Admin Page</h1>
<table>
<tr>
<td>
<form action="InactiveController" method="post">
<input type="submit" value="Inactive Employees">
</form>
</td>
<td>
<form action="ActiveController" method="post">
<input type="submit" value="Active Employees">
</form>
</td>
<td>
<a href="PayRollController?flag=payd"><input type="button" value="Pay Employee"></a>
</td>
</tr>
</table>
${ManagerAssigned}
${paid}
</body>
</html>