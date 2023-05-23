<%@ page import="bean.ATM" %>
<%@ page import="dao.ATMDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>getMoneyDo</title>
    </head>
    <body>
        <%
            // 获取取款金额
            double money = Double.valueOf(request.getParameter("money"));
            // 获取卡号
            ATM atmuser = (ATM) session.getAttribute("atmuser");
            String atmCode = atmuser.getAtmCode();
            // 取钱
            ATMDao atmDao = new ATMDao();
            boolean b = atmDao.getMoney(atmCode, money);
            if(b) {
        %>
            <h1>取款成功！</h1>
        <%
            }else {
        %>
            <h1>取款失败！</h1>
        <%
            }
        %>
    </body>
</html>
