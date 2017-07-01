<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="Model.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Another Team Details</title>
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
<%
ArrayList<Model_Registration> reg = (ArrayList<Model_Registration>) session.getAttribute("reglist");
%>
<form action="AnotherTeamDetailsController" method="post">
<input type="hidden" value="<%=session.getAttribute("dirid")%>" name="dirid">
<%-- <input type="hidden" value="<%=request.getAttribute("anotherempid")%>" name="anotherempid"> --%>
<h4>Are you sure want to give access to the employee with following details?</h4>
<table>
<tr><td>DirectoryName:<%=request.getAttribute("dirname")%></td></tr>
<tr><td>DitectoryType:<%=request.getAttribute("dirtype")%></td></tr>
<tr><td>AccessGivenToId: <select name="emp">
<% for(int j=0;j<reg.size();j++){%>
<option value="<%=reg.get(j).getEmp_Id()%>"><%=reg.get(j).getUserName()%></option>
<%} %>
</select>
</td>
</tr>
</table>
<input type="submit" value="AddEmployee">
</form>
<%} %>
</body>
</html>