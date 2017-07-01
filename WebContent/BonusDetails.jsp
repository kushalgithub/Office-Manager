<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<% if(session.getAttribute("id")==null){
	response.sendRedirect("index.jsp");	
}

else if(session.getAttribute("emptype").equals("admin")){
	response.sendRedirect("admin.jsp");	
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

<form action="AssignBonusController" method="post">
<table>
<h1>Add Bonus To Employee</h1>
<tr><td>FirstName:${fn}</td></tr>
<tr><td>LastName:${ln}</td></tr>
<tr><td>Bonus:<input type="text" name="bonus"></td></tr>
<tr><td><input type="hidden" name="pid" value=<%=request.getAttribute("pid") %>></td></tr>
<tr><td><input type="hidden" name="eid" value=<%=request.getAttribute("eid") %>></td></tr>
<tr><td><input type="submit" value="submit"></td></tr>

<tr><td>${error}</td></tr>

</table>

</form>
<%} %>
</body>
</html>