<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="margin-left:1200px">
<form action="LogoutController" method="post">
<input type="submit" value="Logout">
</form>
</div>
<form action="AddFilesToDir" method="post" enctype="multipart/form-data">

<input type="hidden" name="dirid" value="<%=session.getAttribute("dirid")%>">

<table>

<tr><td><%=request.getAttribute("dn")%></td></tr>
<tr><td><%=request.getAttribute("dt") %></td></tr>
<tr><td>AddFile To Directory:<input type="file" name="addfile" ></td></tr>
<tr><td><input type="submit" value="upload"></td></tr>

</table>




</form>
</body>
</html>