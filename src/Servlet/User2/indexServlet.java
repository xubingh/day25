package Servlet.User2;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class indexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //req:响应
        //resp:请求
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1、判断用户是否登录
        // 要获得会话的对象
        //session：会话
        HttpSession session = req.getSession();
        // 从会话中获取用户信息
        Object userInfo = (String)session.getAttribute("userInfo");
        // 1.1 如果登录了就显示当前类的内容
        if(userInfo!=null){
        PrintWriter out=resp.getWriter();
            out.println("首页");
        }else{
            // 1.2 如果未登录就跳转loginHtmlServlet
                    //Attribute:属性
                req.setAttribute("msg","必须登录才能浏览界面");
                //reques:要求
            //Disoatcher:分配
                req.getRequestDispatcher("loginHtmlServlet");
        }
    }
}
