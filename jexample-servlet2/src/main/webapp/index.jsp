<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.dev118.jexample.servlet2.LoginServlet"%>
<%
	String path = request.getContextPath();
	String serverHost = request.getServerName();
	String basePath = request.getScheme() + "://" + serverHost + ":"
			+ request.getServerPort() + path + "/";
%>
<html>
<body>
	Welcome:<%=session.getAttribute(LoginServlet.SESSION_KEY_USERNAME)%>
	,
	<a href="<%=basePath%>LogoutServlet">Logout</a>
	<h2>Hello World!</h2>
</body>
</html>
