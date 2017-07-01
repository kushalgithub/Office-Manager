<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="Model.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Inactive Employee List</title>
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


<h1>Inactive Employees</h1>
<%
ArrayList<Model_Registration> ps = (ArrayList<Model_Registration>) session.getAttribute("inactivelist");
%>

<table>
<tr><td>First Name</td><td>Last Name</td><td>Email</td><td>Status</td></tr>
<% for(int i=0;i<ps.size();i++){%>
<tr>
<td><%=ps.get(i).getFirstName() %></td>
<td><%=ps.get(i).getLastName() %></td>
<td><%=ps.get(i).getPersonal_Email() %></td>
<td><%=ps.get(i).getIsActive() %></td>
<td><a href="ListManagerController?flag=manager&id=<%=ps.get(i).getEmp_Id()%>&firstname=<%=ps.get(i).getFirstName()%>&lastname=<%=ps.get(i).getLastName()%>&address=<%=ps.get(i).getAddress()%>&email=<%=ps.get(i).getPersonal_Email()%>">Assign_Manager</a></td>	
</tr>
<%} %>

</table>
<%} %>
</body>
</html>