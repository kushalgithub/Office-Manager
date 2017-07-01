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

<h1>Change Permissions List</h1>
<a href="ChangeDirectoryListController?flag=listdir&id=<%out.println(session.getAttribute("id"));%>">Public Directory</a>
<%-- <a href="ChangeDirectoryListController?flag=prilistdir&id=<%out.println(session.getAttribute("id"));%>">Private Directory</a> --%>
<a href="ChangeDirectoryListController?flag=prolistdir&id=<%out.println(session.getAttribute("id"));%>">Protected Directory</a>
<a href="ChangeDirectoryListController?flag=deflistdir&id=<%out.println(session.getAttribute("id"));%>">Default Directory</a>
<%} %>
</body>
</html>