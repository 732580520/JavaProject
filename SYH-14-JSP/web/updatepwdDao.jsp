<%@ page import="bean.ATM" %>
<%@ page import="dao.ATMDao" %><%--
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
    // 接受参数
    String atmPwd = request.getParameter("pwd");
    String newPwd = request.getParameter("newPwd");
    // 验证登录
    ATMDao atmDao = new ATMDao();
    ATM atm = atmDao.atmLoginDao(atmCode, atmPwd);
    if(atm != null) {
        boolean b = atmDao.updatePwdDao(atmCode, atmPwd,newPwd);
        if(b) {
    %>
    <h1>密码修改成功，请重新 <a href="login.jsp">登录</a></h1>
         <%   }else{
    %>
    <h1>新密码与原密码一致，请重新 <a href="updatepwd.jsp">修改</a></h1>
    <%
        }
    }else{
    %>
            <h1>原密码错误，请重新 <a href="updatepwd.jsp">修改</a></h1>
    <%
        }
    %>
</body>
</html>
