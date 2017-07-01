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

<div style="margin-left:1200px">
<form action="LogoutController" method="post">
<input type="submit" value="Logout">
</form>
</div>

<%
ArrayList<Model_DirectoryFiles_Retrieve> ps = (ArrayList<Model_DirectoryFiles_Retrieve>) session.getAttribute("filelist");
%>

<table>
<tr><td>DirectoryFile_Id</td><td>DirectoryFile_Name</td><td>DirectoryFile_Type</td></tr>

<% for(int i=0;i<ps.size();i++){%>
<tr>
<td><%=ps.get(i).getDirectoryFile_Id() %></td>
<td><%=ps.get(i).getDirectoryFile_Name() %></td>
<td><%=ps.get(i).getDirectoryFile_Type() %></td>
<td><a href="view.jsp?viewid=<%=ps.get(i).getDirectoryFile_Id() %>">ViewFile</a></td>
</tr>
<%} %>

</table>
</body>
</html>