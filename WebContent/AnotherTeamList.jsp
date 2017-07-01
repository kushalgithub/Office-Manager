<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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
<h1>Give Access To Another Team Employee</h1>

<%
ArrayList<Model_Directory> ps = (ArrayList<Model_Directory>) session.getAttribute("anotherlist");
%>

<%
ArrayList<Model_Registration> reg = (ArrayList<Model_Registration>) session.getAttribute("reglist");
%>


<table>
<tr><td>Directory Id</td><td>Directory Name</td><td>Directory Type</td></tr>
<% for(int i=0;i<ps.size();i++){%>

<tr>
<td><%=ps.get(i).getDir_Id()%></td>
<td><%=ps.get(i).getDirName()%></td>
<td><%=ps.get(i).getDirType()%></td>
<td>
<%-- <select name="emp">
<% for(int j=0;j<reg.size();j++){%>
<option value="<%=reg.get(j).getEmp_Id()%>"><%=reg.get(j).getUserName()%></option>
<%} %>
</select>
 --%></td>
<td><a href="ATEController?flag=atedetail&dirid=<%=ps.get(i).getDir_Id()%>&dirname=<%=ps.get(i).getDirName()%>&dirtype=<%=ps.get(i).getDirType()%>">Give Access</a></td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>