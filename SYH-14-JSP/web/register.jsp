<%@ page contentType="text/html;charset=UTF-8" language="java" %>
    <html>
    <head>
        <title>register</title>
    </head>
    <body>
        <center>
            <h1 style="color: red">欢迎注册动力银行</h1>
            <form action="registerDo.jsp" method="post">
                姓名：<input type="text" name="atmName"> <br>
                密码：<input type="password" name="atmPwd"> <br>
                <input type="submit" value="提交注册">
            </form>
            <a href="login.jsp">已有账号，去登录</a>
        </center>
    </body>
</html>
