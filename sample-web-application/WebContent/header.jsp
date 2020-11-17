<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>Welcome To My Online Website</h2>
<hr>
<a href="index.jsp">Home</a> |
<a href="register.jsp">Register</a> |
<a href="login.jsp">Login</a>| 
<% String user = (String)session.getAttribute("loggedInUser"); %> 
<%=user %> |

<a href="logout.jsp">Logout</a>
<hr>