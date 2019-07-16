package Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Testservlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloWorldServlet doGet...");
    }

    // 每次通过post方式请求服务器调用
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("HelloWorldServlet doPost...");
    }

    // web服务器关闭时调用destroy方法
    @Override
    public void destroy() {
        System.out.println("HelloWorldServlet destroy...");
    }

    // web服务器实例化Servlet之后调用init方法，只会执行1次（初始化）
    @Override
    public void init() throws ServletException {
        System.out.println("HelloWorldServlet init...");
    }
}
