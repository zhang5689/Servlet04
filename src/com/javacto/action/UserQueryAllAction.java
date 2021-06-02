package com.javacto.action;


import com.javacto.po.User;
import com.javacto.service.UserService;
import com.javacto.service.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/queryUserALL.do")
public class UserQueryAllAction extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String name = req.getParameter("userName");
        String pwd = req.getParameter("pwd");

        UserService userService = new UserServiceImpl();
        List<User> list  =userService.queryAll();
        //把结果存在HttpServletRequest 对象中
        req.setAttribute("list",list);
        req.getRequestDispatcher("userList.jsp").forward(req,resp);
    }
}
