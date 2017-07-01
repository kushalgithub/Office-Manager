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

%>


<div style="margin-left:1200px">
<form action="LogoutController" method="post">
<input type="submit" value="Logout">
</form>
</div>

<h1>Manager Page</h1>
<a href="LeaveRequestController?flag=employee&id=<%out.println(session.getAttribute("id"));%>">Leave</a>
<a href="LeaveRequestManagerController?flag=list&id=<%out.println(session.getAttribute("id"));%>">Requested Leaves</a>
<a href="AssignBonusController?flag=manager&id=<%out.println(session.getAttribute("id"));%>">Assign Bonus</a>
<a href="ViewPayCheckController?flag=check&id=<%out.println(session.getAttribute("id"));%>">View Pay Check</a>
<a href="DirectoryController?flag=dir&id=<%out.println(session.getAttribute("id"));%>">Create Directory</a>
<a href="DirectoryListController?flag=dirlist&id=<%out.println(session.getAttribute("id"));%>">View Directory</a>
<a href="ATEController?flag=pro&id=<%out.println(session.getAttribute("id"));%>">Another Team Employee</a>
<a href="ChangeDirectoryListController?flag=change&changeid=<%out.println(session.getAttribute("id"));%>">Change Directory Permissions</a>
<table>
<tr><td>${anotheremp}</td></tr>
<tr><td>${dircreated}</td></tr>
<tr><td>${changed}</td></tr>
</table>
</body>
</html>