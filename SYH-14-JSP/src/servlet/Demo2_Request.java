package servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Demo2_Request extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 接收demo01通过域对象保存的数据
        String name = (String)request.getAttribute("name");
        int age = (int)request.getAttribute("age");
        System.out.println(name + "....." + age);
    }
}
