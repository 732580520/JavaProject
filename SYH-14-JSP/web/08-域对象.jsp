<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>08-域对象</title>
    </head>
    <body>
        <%
            // 域对象中保存数据
            request.setAttribute("name", "张无忌");
            request.setAttribute("age", 38);
            // 转发
            request.getRequestDispatcher("07-域对象.jsp").forward(request, response);
        %>
    </body>
</html>
