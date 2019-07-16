package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet  extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 登录功能
        // 获取客户端发送过来的数据
        // http://localhost:8080/loginServlet?username=admin&password=123
        // request：请求对象，用于获取客户端浏览器发送过来的数据
        // String request.getParameter(String name)

        req.setCharacterEncoding("utf-8");
        String username=req.getParameter("username");
        String password=req.getParameter("password");
        String checkbox1=req.getParameter("checkbox1");
        resp.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out=resp.getWriter();

        out.println("用户名:"+username);
        out.println("密码:"+password);
        out.println("性别:"+checkbox1);
        String[] checkboxes = req.getParameterValues("check");
        out.println("兴趣爱好");
        for(int i =0;i<checkboxes.length;i++){
            out.println(checkboxes[i]);
        }
    }
}
