<%@ page import="bean.ATM" %><%--
  Created by IntelliJ IDEA.
  User: 73258
  Date: 2023/5/22
  Time: 17:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    ATM atmuser = (ATM) session.getAttribute("atmuser");
    String atmCode = atmuser.getAtmCode();
%>

<%--    <form action="updatepwdDao.jsp" method="post" onsubmit="checks()">--%>
<%--        账号：<input type="text" name="account" disabled value=<%=atmCode%>> <br>--%>
<%--            原密码：<input type="text" name="pwd"> <br>--%>
<%--            新密码：<input type="text" name="newPwd"> <br>--%>
<%--            确认密码：<input type="text" name="confirmPwd" onmouseleave="checks()"><span id="warning"> </span><br>--%>
<%--        <input type="submit" value="提交">--%>
<%--    </form>--%>
<center>
<form id="updatePwdForm" action="updatepwdDao.jsp" method="post">
<%--    账号：<input type="text" name="account" required disabled value=<%=atmCode%>><br>--%>
<%--    原密码:<input type="password"  name="pwd" required><br>--%>
<%--    新密码:<input type="password" id="password" name="newPwd" required><br>--%>
<%--    确认密码:<input type="password" id="confirmPassword" name="confirmPwd" required><br>--%>
<%--    <input type="submit" value="提交">--%>
    <table>
        <tr>
            <td>账号：</td>
            <td><input type="text" name="account" required disabled value=<%=atmCode%>></td>
        </tr>
        <tr>
            <td>原密码：</td>
            <td><input type="password"  name="pwd" required></td>
        </tr>
        <tr>
            <td>新密码：</td>
            <td><input type="password" id="password" name="newPwd" required></td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td><input type="password" id="confirmPassword" name="confirmPwd" required></td>
        </tr>
        <tr>
            <td></td>
            <td><input type="reset" value="重置" />&nbsp;&nbsp;&nbsp;&nbsp;<input type="submit" value="提交"></td>
        </tr>
    </table>
</form>
</center>
<style>
    table {
        text-align:center;
    }
</style>
<script>
    document.getElementById('updatePwdForm').addEventListener('submit', function(event) {
        var password = document.getElementById('password').value;
        var confirmPassword = document.getElementById('confirmPassword').value;
        if (password !== confirmPassword) {
            event.preventDefault();
            alert('两次密码不一致');
        }
    });
</script>
</body>
</html>