<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@page import="Model.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Assign Bonus</title>
</head>
<body>
<% if(session.getAttribute("id")==null){
	System.out.println("1");
	response.sendRedirect("index.jsp");	
}

else if(session.getAttribute("emptype").equals("admin")){
	System.out.println("2");

	response.sendRedirect("admin.jsp");	
}

else if(session.getAttribute("emptype").equals("employee")){
	
	System.out.println("3");
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
ArrayList<Model_PayRoll> ps = (ArrayList<Model_PayRoll>) session.getAttribute("bonuslist");
System.out.println("Inside Ps"+ps.size());
%>

<h1>Assign Bonus</h1>
<table>
<tr><td>First Name</td><td>Last Name</td><td>Salary</td><td>Month</td><td>Year</td></tr>
<% for(int i=0;i<ps.size();i++){%>
<tr>
<td><%=ps.get(i).getFirstName() %></td>
<td><%=ps.get(i).getLastName() %></td>
<td><%=ps.get(i).getMonth_Salary() %></td>
<td><%=ps.get(i).getMonth() %></td>
<td><%=ps.get(i).getYear() %></td>	
<td><a href="AssignBonusController?flag=bonus&eid=<%=ps.get(i).getEmp_Id() %>&pid=<%=ps.get(i).getPay_Id()%>&firstname=<%=ps.get(i).getFirstName()%>&lastname=<%=ps.get(i).getLastName()%>">AddBonus</a></td>
</tr>
<%} %>
<tr><td>${Bonus}</td></tr>

</table>
<%} %>
</body>

</html>