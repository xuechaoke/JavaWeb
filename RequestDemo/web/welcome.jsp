<%@ page import="com.ciao.bean.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>欢迎登陆</title>
</head>
<body>
<%User user = (User) request.getAttribute("user");%>

<h1>欢迎<%=user.getuserName()%>登陆</h1>
</body>
</html>
