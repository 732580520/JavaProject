<%--
  Created by IntelliJ IDEA.
  User: 73258
  Date: 2023/5/22
  Time: 17:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<center>
<form action="transferDao.jsp" method="post">
    对方账号：<input type="text" name="transferCode"> <br>
    转账金额：<input type="text" name="money"> <br>
    <input type="submit" value="确认转账">
</form>
</center>
</body>
</html>
