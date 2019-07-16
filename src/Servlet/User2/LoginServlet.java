package Servlet.User2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、设置编码方式
        //session:会话
        //
        req.setCharacterEncoding("utf-8");
        //获得数据
        String username=req.getParameter("username");
        String password = req.getParameter("password");
        // 3、验证数据是否合法
        // 用户名和密码都不能为空，登录成功，否则就失败
        if (username!=null && !"".equals(username) &&password!=null && !"".equals(password)){
            //实例化对象
            User1 user = new User1(username,password);
            // 3.2 将用户对象存入会话
            // 获得会话
            HttpSession session =req.getSession();
            // 通过方法将用户对象存入
            session.setAttribute("userInfo",user);
            // 重定向到indexServlet
            resp.sendRedirect("indexServlet");
        }else{
            //  3.2、失败就跳转到失败页面，并将错误消息输出（转发）
            req.setAttribute("msg", "用户名或密码错误");
        req.getRequestDispatcher("loginHtmlServlrt").forward(req,resp);
        }
    }
}
