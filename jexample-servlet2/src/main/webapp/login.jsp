<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%    
String path = request.getContextPath();   
String serverHost = request.getServerName();
String basePath = request.getScheme() + "://" + serverHost + ":" + request.getServerPort() + path + "/";
%>
<html>
<body>
<h2>Login</h2>
<form method="post" action="<%=basePath%>LoginServlet">
<input type="text" name="username" />
<br/>
<input type="password" name="password" />
<br/>
<input type="submit" value="Login" />
</form>
</body>
</html>
