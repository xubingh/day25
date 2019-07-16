package Servlet.User2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class LoginServlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置浏览器输出的样式
        resp.setContentType("text/html;charset=utf-8");
        //数据以什么形式返回给浏览器
        resp.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<titl>登录界面</title>");
        out.println("</head>");
        out.println("<body>");

        //获得错误信息
        String msg = (String) req.getAttribute("msg");
        out.println("<div style='color:red'>"+msg+"</div>");
        out.println("<form action=\"loginServlet\" method=\"post\">");
        out.println("用户名：<input type=\"text\" name=\"username\"><br/>");
        out.println("密码：<input type=\"password\" name=\"password\"><br/>");
        out.println("<input type=\"submit\" value=\"登陆\">");
        out.println("</form>");
        out.println("</body>");
        out.println("</html>");
    }
}
