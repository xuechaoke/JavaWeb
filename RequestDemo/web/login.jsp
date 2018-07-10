<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/8/008
  Time: 19:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>loginPage</title>
</head>
<%

    String msg = (String) request.getAttribute("msg");
    if (msg==null) {
        msg="";
    }
%>
<body>
<div style="color: red"><%=msg%></div>
<form method="post" action="login">
   用户名: <input type="text" name="userName"/><br>
    密码:  <input type="password" name="passWord"/><br>
    <input type="submit" value="login"/>
</form>
</body>
</html>
