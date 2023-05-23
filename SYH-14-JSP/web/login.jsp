<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>login</title>
    </head>
    <body>
    <center>
        <h1 style="color: green">欢迎登录动力银行</h1>
        <form action="loginDo.jsp" method="post">
            账号：<input type="text" name="atmCode"> <br>
            密码：<input type="password" name="atmPwd"> <br>
            <input type="submit" value="登录">
        </form>
        <a href="register.jsp">没有账号，去注册</a>
    </center>
    </body>
</html>
