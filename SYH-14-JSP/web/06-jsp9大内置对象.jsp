<%@ page import="java.io.PrintWriter" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>06-jsp9大内置对象</title>
    </head>
    <body>
        <%
            // 请求对象 request
            String uname = request.getParameter("uname");
            System.out.println("uname = " + uname);
            // 响应对象 response
            PrintWriter writer = response.getWriter();
            writer.write("Hello 浏览器！！");

            // 输出对象 out
            out.write("Hello 浏览器！！");
        %>
    </body>
</html>
