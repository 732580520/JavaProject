<%@ page import="dao.ATMDao" %>
<%@ page import="bean.ATM" %><%--
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
<%

    // 获取转账金额
    double transmoney = Double.valueOf(request.getParameter("money"));
    // 获取卡号
    ATM atmuser = (ATM) session.getAttribute("atmuser");
    String atmCode = atmuser.getAtmCode();
    // 获取余额
    double money = atmuser.getAtmMoney();
    // 获取转账账号
    String transferCode = request.getParameter("transferCode");
    // 取钱
    ATMDao atmDao = new ATMDao();
    boolean b = atmDao.transferDao(atmCode, transferCode, money, transmoney);
    if (b) {
        %>
      <h1>转账成功！</h1>
      <%
    } else {
      %>
      <h1>转账失败！</h1>
      <%
    }
      %>
</body>
</html>
