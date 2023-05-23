<%@ page import="dao.ATMDao" %>
<%@ page import="bean.ATM" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>loginDo</title>
    </head>
    <body>
        <%
            // 请求编码
            request.setCharacterEncoding("utf-8");
            // 接受参数
            String atmCode =(String) request.getAttribute("atmCode");
            System.out.println(atmCode);
            String atmPwd =(String) request.getAttribute("atmPwd");
            System.out.println(atmPwd);
            if(atmCode==null)atmCode=request.getParameter("atmCode");
            System.out.println(atmCode);
            if(atmPwd==null)atmPwd=request.getParameter("atmPwd");
            System.out.println(atmPwd);
            ATMDao atmDao = new ATMDao();
            ATM atm = atmDao.atmLoginDao(atmCode, atmPwd);
            if(atm != null) {
                // 将用户信息保存到域对象中
                session.setAttribute("atmuser", atm);
        %>
            <h1>登录成功，欢迎<%=atm.getAtmName()%>使用动力银行</h1>
            <a href="queryMoneyDo.jsp">查询余额</a>
            <a href="setMoney.jsp">存款</a>
            <a href="getMoney.jsp">取款</a>
            <%--
                1.自己的卡号
                2.自己的余额
                3.对方的卡号
                4.转账的金额
            --%>
            <a href="transfer.jsp">转账</a>
            <%--
                1.卡号
                2.原密码 --> 验证原密码是否正确
                3.新密码
            --%>
            <a href="updatepwd.jsp">修改密码</a>
        <%
            }else{
        %>
            <h1>账号或密码错误，请重新 <a href="login.jsp">登录</a></h1>
        <%
            }
        %>
    </body>
</html>
