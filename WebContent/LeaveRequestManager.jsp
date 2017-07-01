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

<%
ArrayList<Model_LeaveRequest> ps = (ArrayList<Model_LeaveRequest>) session.getAttribute("leavelist");
%>
<table>
<tr><td>FirstName</td><td>LastName</td><td>StartDate</td><td>EndDate</td><td>Reason</td><td>LeaveDays</td><td>Approve</td><td></td></tr>
<% for(int i=0;i<ps.size();i++){%>
<tr>
<td><%=ps.get(i).getFirstName() %></td>
<td><%=ps.get(i).getLastName() %></td>
<td><%=ps.get(i).getStartDate() %></td>
<td><%=ps.get(i).getEndDate() %></td>
<td><%=ps.get(i).getReason() %></td>
<td><%=ps.get(i).getLeaveDays() %></td>
<td><%if(ps.get(i).getApprove()==1){%>Approved<% }%><%else{%>Not Approved<%}%></td>
<td>
<a href="LeaveRequestManagerController?flag=Approvelist&id=<%=ps.get(i).getRequest_Id() %>&leavedays=<%=ps.get(i).getLeaveDays()%>&empid=<%=ps.get(i).getEmp_Id() %>">Approve</a>
<a href="LeaveRequestManagerController?flag=Discardlist&id=<%=ps.get(i).getRequest_Id() %>">Discard</a>
</td>
</tr>
<%} %>

</table>
<%} %>
</body>
</html>