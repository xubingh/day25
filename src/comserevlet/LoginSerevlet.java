package comserevlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginSerevlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置编码
        resp.setContentType("utf-8");
        //获得表单数据
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        //拿到数据库中的信息
        HttpSession session = req.getSession();
        Object userInfo = session.getAttribute("userInfo");
        // 2、验证数据是否合法(避免通过改网页进入)
        // 2.1用户名和密码都不能为空，否则就失败
        if (username != null && !"".equals(username) && password !=null && !"".equals(password) ){

        }else {
            //  2.2、失败就跳转到失败页面，并将错误消息输出（转发）
            req.setAttribute("msg","输入有误");
            req.getRequestDispatcher("Login.jsp").forward(req,resp);
        }

    }
}
