<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>01-JSP概述</title>
    </head>
    <body>
        <%--
            Jsp的本质是对servlet的封装，servlet是被服务器创建并运行的，Jsp需要被服务器编译。 将servlet+html封装到一起。
            jsp执行步骤
                1.转义 .jsp --> .java    tomcat完成
                2.编译 .java --> .class  jvm完成
                3.运行 .class jvm完成  html代码 浏览器完成
            jsp的执行：jsp无法直接通过浏览器打开，必须使用Tomcat服务开启
        --%>
        <%--java代码--%>
        <%
            System.out.println("Hello World!");
            String uname = request.getParameter("uname");
            PrintWriter writer = response.getWriter();
        %>
        <%--html代码--%>
        <h1>标题标签</h1>
    </body>
</html>
