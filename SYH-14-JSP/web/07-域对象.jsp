<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>07-域对象</title>
    </head>
    <body>
        <%
            // 通过域对象获取数据
            Object name = request.getAttribute("name");
            Object age = request.getAttribute("age");
        %>
        我的jsp页面，这是我接收到的08-域对象保存的数据：<%=name%>...<%=age%>
    </body>
</html>
