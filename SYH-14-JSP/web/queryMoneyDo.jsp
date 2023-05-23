<%@ page import="dao.ATMDao" %>
<%@ page import="bean.ATM" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>queryMoney</title>
    </head>
    <body>
        <%
            // 获取用户数据
            ATM atmuser = (ATM)session.getAttribute("atmuser");
            String atmCode = atmuser.getAtmCode();
            ATMDao atmDao = new ATMDao();
            double money = atmDao.queryMoneyDao(atmCode);
        %>
        <h1><%=atmuser.getAtmName()%>您当前的余额为：<%=money%></h1>
    </body>
</html>
