<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>03-jsp中java代码的连贯性</title>
    </head>
    <body>
        <%--在同一个jsp页面中，所有的java代码片段都是相通连贯的--%>
        <%
            int age = 28;
            if(age > 18) {
        %>
            <h1 style="color: green">大爷来玩呀!</h1>
        <%
            }else {
        %>
            <h1 style="color: red;">未成年人禁止入内!</h1>
        <%
            }
        %>
    </body>
</html>
