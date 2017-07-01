<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%-- <% if(session.getAttribute("id")==null){ --%>
// 	response.sendRedirect("index.jsp");	
// }

// else if(session.getAttribute("emptype").equals("admin")){
// 	response.sendRedirect("admin.jsp");	
// }

// else if(session.getAttribute("emptype").equals("employee")){
// 	response.sendRedirect("manager.jsp");	
// }

<%-- %> --%>



<div style="margin-left:1200px">
<form action="LogoutController" method="post">
<input type="submit" value="Logout">
</form>
</div>


<h1>Employee Page</h1>
<a href="LeaveRequestController?flag=employee&id=<%out.println(session.getAttribute("id"));%>">Leave</a>
<a href="ViewPayCheckController?flag=check&id=<%out.println(session.getAttribute("id"));%>">View Pay Check</a>
<a href="DirectoryListController?flag=dirlist&id=<%out.println(session.getAttribute("id"));%>">View Directory</a>
</body>
</html>