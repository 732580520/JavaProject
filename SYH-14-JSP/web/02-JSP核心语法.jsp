<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.Collections" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>02-JSP核心语法</title>
    </head>
    <body>
        <%--这是注释--%>
        <!--这是注释-->
        <%--
            <% java代码片段，java中怎么写，这里就能怎么写。在一个页面中所有的java代码片段是相通。%>
            <%=值|变量%>
            <%!类属性%> java定义类成员，几乎不使用
        --%>
        <%--java代码的片段--%>
        <%
            System.out.println("Hello World!");
            int a = 10;
            int b = 20;
            int sum = a + b;
            System.out.println("sum = " + sum);
            ArrayList<String> list = new ArrayList<>();
            Collections.addAll(list,"a","b");
            System.out.println(list);

            String uname = request.getParameter("uname");
            uname = "李四";
        %>
        <h1 style="color: red">欢迎<%=uname%>大驾光临</h1>

    </body>
</html>
