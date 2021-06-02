package com.javacto.action;

import com.javacto.po.User;
import com.javacto.service.UserService;
import com.javacto.service.UserServiceImpl;

import javax.jws.WebService;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet("/login.do")
public class LoginAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //处理请求编码格式
        req.setCharacterEncoding("UTF-8");
        //处理响应编码格式
        resp.setContentType("text/html;charset=UTF-8");
        //1.获取请求参数
        String name = req.getParameter("userName");
        String pwd = req.getParameter("pwd");
        //2.创建业务层代码
        UserService userService = new UserServiceImpl();
        //3.调用方法
        User user = userService.login(name,pwd);
        if(null!=user){
            System.out.println("登陆成功");
            //实际开发，会再去调用一个查询用户信息的url   req.getRequestDispatcher("填你的路径").forward(req,resp);
            req.getRequestDispatcher("/queryUserALL.do").forward(req,resp);
        }else{
            System.out.println("登陆失败");
            req.getRequestDispatcher("/login.jsp").forward(req,resp);
        }
    }
}
