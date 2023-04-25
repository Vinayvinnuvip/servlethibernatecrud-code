<%@page import="com.service.User1Service"%>
<%@page import="com.dto.User1"%>
<%@page import="java.util.List"%>
<%@page import="com.dao.User1Dao"%>
<%@page import="javax.persistence.*"%>
<%@page session="false" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta char set="UTF-8">
<title>View page</title>
</head>
<body>
<% HttpSession session=request.getSession(false);
if(session!=null){
	User1Service us = new User1Service();
	List<User1> list = us.getAllDetails();
	%><table border=2px>
	<thead>
	<tr>
	<th>ID</th>
	<th>Name</th>
	<th>Age</th>
	<th>Email</th>
	<th>Password</th>
	</tr>
	</thead>
	<%for(User1 u:list){ %>
	
	
	<tr>
	<td><%=u.getId() %></td>
	<td><%=u.getName() %></td>
	<td><%=u.getAge() %></td>
	<td><%=u.getEmail() %></td>
	<td><%=u.getPassword() %></td>
	
	</tr>
	
	
	<%} %>
	</table>
	<%}else{%>
		<h1>not a valid user</h1>
		<a href="login.html">click here to login</a>
	<%} %>

</body>
</html>