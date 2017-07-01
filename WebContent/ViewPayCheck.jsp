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
ArrayList<Model_PayRoll> ps = (ArrayList<Model_PayRoll>) session.getAttribute("paychecklist");
%>
<h1>My Pay Cheques</h1>
<table>
<tr><td>Pay Id</td><td>Month</td><td>Year</td><td>Salary</td><td>Bonus</td></tr>
<% for(int i=0;i<ps.size();i++){%>
<tr>
<td><%=ps.get(i).getPay_Id() %></td>
<td><%=ps.get(i).getMonth() %></td>
<td><%=ps.get(i).getYear() %></td>
<td><%=ps.get(i).getMonth_Salary() %></td>
<td><%=ps.get(i).getBonus() %></td>	
</tr>
<%} %>
</table>

</body>
</html>