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

<h1>Employee Details</h1>
<form action="PayRollController" method="post">
<table>
<tr><td>FirstName:${fn}</td></tr>
<tr><td>LastName:${ln}</td></tr>
<tr><td>Address:${add}</td></tr>
<tr><td>Email:${email}</td></tr>
<tr><td>Salary:${salary}</td></tr>
<tr>
<td>
Month:<select name="month">
<option value="January">January</option>
<option value="February">February</option>
<option value="March">March</option>
<option value="April">April</option>
<option value="May">May</option>
<option value="June">June</option>
<option value="July">July</option>
<option value="August">August</option>
<option value="September">September</option>
<option value="October">October</option>
<option value="November">November</option>
<option value="December">December</option>
</select>
</td>
</tr>
<tr>
<td>
Year:<select name="year">
<option value="2017">2017</option>
<option value="2018">2018</option>
<option value="2019">2019</option>
<option value="2020">2020</option>
</select>
</td>
<!-- <tr><td><input type="text" name="AssignSalary"></td></tr> -->
<tr><td><input type="hidden" value="<%=request.getAttribute("id")%>" name="empid"></td></tr>
<tr><td><input type="hidden" value="<%=request.getAttribute("salary")%>" name="salary"></td></tr>
<tr><td><input type="submit" value="AssignSalary"></td></tr>
<tr><td>${fail}</td></tr>
</table>
</form>

</body>
</html>