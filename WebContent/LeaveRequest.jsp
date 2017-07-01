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
ArrayList<Model_LeaveRequest> ps = (ArrayList<Model_LeaveRequest>) session.getAttribute("leavelist");
%>

<h1>Leave Request</h1>
<form action="LeaveRequestController" method="post">
<table>
<tr><td>From:</td><td><input type="date" name="date1"></td></tr>
<tr><td>To:</td><td> <input type="date" name="date2"></td></tr>
<tr><td>Reason</td><td> <input type="text" name="reason"></td></tr>
<tr><td></td><td><input type="submit" value="Request"></td></tr>
<tr><td></td><td>${NotValid}</td></tr>
</table>
<table>
<tr><td>StartDate</td><td>EndDate</td><td>Reason</td><td>Approve</td></tr>
<% for(int i=0;i<ps.size();i++){%>
<tr>
<td><%=ps.get(i).getStartDate() %></td>
<td><%=ps.get(i).getEndDate() %></td>
<td><%=ps.get(i).getReason() %></td>
<td><%if(ps.get(i).getApprove()==1){%>Approved<% }%><%else{%>Not Approved<%}%></td>

</tr>
<%} %>
</table>
${leave}
</form>
</body>
</html>