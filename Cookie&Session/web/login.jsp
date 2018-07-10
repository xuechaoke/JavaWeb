<%@ page import="com.ciao.bean.User" %><%--
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
<script>
    function changecode(obj){
        obj.src="code?"+new Date()
    }

</script>
<%

    String msg = (String) request.getAttribute("msg");
    if (msg==null) {
        msg="";
    }
    //用户记住用户名放入input输入框
    String username="";
    //如果cookie里有username 这个cookie。 说明记住了用户名。让checked="checked"
    String htmlStr="";
    Cookie[] cookies = request.getCookies();

    if (cookies!=null) {
        for (Cookie cookie : cookies) {
            if ("username".equals(cookie.getName())) {
                username=cookie.getValue();
                htmlStr="checked='checked'";
            }

        }
    }
%>
<body>
<div style="color: red"><%=msg%></div>
<form method="post" action="login">
   用户名: <input type="text" value="<%=username%>" name="userName"/><br>
    密码:  <input type="password" name="passWord"/><br>
    验证码:<input type="text" name="code"/><br>
    <img src="code" name="code" onclick="changecode(this)"><br>
    记住用户<input type="checkbox" name="remember" value="true" <%=htmlStr%>/><br>
    <input type="submit" value="登录"/>
</form>
</body>
</html>
