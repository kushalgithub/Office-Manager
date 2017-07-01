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
<title>Insert title here</title>
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

<%
ArrayList<Model_Registration> ps = (ArrayList<Model_Registration>) session.getAttribute("managerlist");
%>
<form action="ListManagerController" method="post">
<table style="border:1px,color:black">
<tr><input type="hidden" name="id" value="<%=session.getAttribute("id")%>"></tr>
<tr><td>First Name</td><td><lable><%=session.getAttribute("firstname")%></lable></td></tr>
<tr><td>Last Name</td><td><lable><%=session.getAttribute("lastname")%></lable></td></tr>
<tr><td>Address</td><td><lable><%=session.getAttribute("address")%></lable></td></tr>
<tr><td>Email</td><td><lable><%=session.getAttribute("email")%></lable></td></tr>
<tr><td>Assign Manager</td><td>
<select name="ActiveEmployeeList">
<%for(int i=0;i<ps.size();i++){%>
<option value=<%=ps.get(i).getEmp_Id() %>><%=ps.get(i).getFirstName() %></option>
<%}%>
</td>
</select>
</tr>
<tr><td><input type="submit" value="Assign"></td></tr>
</table>
</form>
<%} %>
</body>
</html>