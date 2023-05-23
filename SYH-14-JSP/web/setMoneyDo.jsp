<%@ page import="bean.ATM" %>
<%@ page import="dao.ATMDao" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>setMoneyDo</title>
    </head>
    <body>
        <%

            //1.获取需要存款的金额和卡号
            double money = Double.valueOf(request.getParameter("money"));
            ATM atmuser = (ATM)session.getAttribute("atmuser");
            String atmCode = atmuser.getAtmCode();
            String atmPwd = atmuser.getAtmPwd();
            //2.到数据库中将金额添加都对应的卡号即可
            ATMDao atmDao=new ATMDao();
            boolean b = atmDao.setMoneyDao(atmCode, money);
            if (b){
                request.setAttribute("atmCode",atmCode);
                request.setAttribute("atmPwd",atmPwd);%>
                <h1>已存入：<%=money%>金额</h1><a id="btn" href="loginDo.jsp" onclick="check1()">返回首页</a>
            <%}else{
                %>
                <h1>存款失败</h1>
                <%
            }
        %>
    </body>
</html>
