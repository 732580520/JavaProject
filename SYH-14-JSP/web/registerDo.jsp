<%@ page import="java.util.Random" %>
<%@ page import="dao.ATMDao" %>
<%@ page import="bean.ATM" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>registerDo</title>
    </head>
    <body>
        <%
            // 设置编码格式  解决接收中文参数的乱码问题
            request.setCharacterEncoding("utf-8");
            // 接收参数
            String atmName = request.getParameter("atmName");
            String atmPwd = request.getParameter("atmPwd");
            // 卡号：888开头 后面跟3位随机数
            String code = "888";
            Random random = new Random();
            // 注册验证
            ATMDao atmDao = new ATMDao();
            while (true) {
                // 生成卡号
                int num = random.nextInt(900) + 100;
                code += num;
                // 判断卡号是否存在
                if(atmDao.checkCode(code)) {
                    // 卡号可以用于注册  结束循环
                    break;
                }
            }
            // 创建ATM对象
            ATM atm = new ATM();
            atm.setAtmCode(code);
            atm.setAtmMoney(0);
            atm.setAtmName(atmName);
            atm.setAtmPwd(atmPwd);
            // 完成注册
            boolean b = atmDao.atmRegisterDao(atm);
            if(b) {
        %>
            <h1>注册成功，您的卡号是<%=code%></h1>
            <a href="login.jsp">立即登录</a> &nbsp;&nbsp;&nbsp;<a href="register.jsp">返回注册</a>
        <%
            }else{
        %>
            <h1>注册失败，请重新 <a href="register.jsp">注册</a></h1>
        <%
            }
        %>
    </body>
</html>
