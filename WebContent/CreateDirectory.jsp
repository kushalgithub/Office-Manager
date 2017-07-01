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

<form action="CreateDirectoryController" method="post">
<table>
<tr><td>DirectoryName:</td><td><input type="text" name="DirectoryName"></td></tr>
<tr><td>DirectoryType:</td>
<td>
<select name="DirectoryType">
<option value="Public">Public</option>
<option value="Private">Private</option>
<option value="Protected">Protected</option>
<option value="Default">Default</option>
</select>
</td>
</tr>
<tr><td></td><td><input type="hidden" value="<%=request.getAttribute("id")%>" name="id"></td></tr>
<tr><td><input type="submit" value="Create Directory"></td><td></td></tr>
<tr><td></td><td>${success}</td></tr>
</table>
</form>
<%} %>

</body>
</html>