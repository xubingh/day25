package Textsession;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserSession extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("utf-8");
        String username =req.getParameter("username");
        String password = req.getParameter("password");
        String hobbies = req.getParameter("hobbies");
        String sex = req.getParameter("sex");
        if (username!=null && !"".equals(username) && password!=null && !"".equals(password)){
            User user = new User("username","password","hobbies","sex");
            HttpSession session = req.getSession();
            session.setAttribute("userInfo",user);
            resp.sendRedirect("UserServlet");
        }else{
            req.setAttribute("msg","确定失败");
            req.getRequestDispatcher("us.jsp").forward(req,resp);
        }
    }

}
