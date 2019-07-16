package Servlet.Jsp;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    req.setAttribute("username","爷爷");
    //req.getSession:会话
    req.getSession().setAttribute("username","大娃");
        //对象数据
        req.setAttribute("userInfo",new user("admin","123"));
        //拆分为两句
        user user=new user("admin","123");
        req.setAttribute("userInfo",user);
        //
        List<user> list=new ArrayList<>();
        for (int i=0; i<10; i++){
            list.add(new user("test"+i,"123"));
        }
        req.setAttribute("list",list);
        req.getRequestDispatcher("el.jsp").forward(req,resp);
    }
}
