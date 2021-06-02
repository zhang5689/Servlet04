package com.javacto.test;

import com.javacto.dao.UserDao;
import com.javacto.dao.UserDaoImpl;
import com.javacto.po.User;
import com.javacto.service.UserService;
import com.javacto.service.UserServiceImpl;

import java.util.List;

/**
 * describe
 * 作者：曾昭武  adam8831
 */
public class TestUser {




    public static void main(String[] args) {
        UserService userService = new UserServiceImpl();
        //UserDao userDao = new UserDaoImpl();
       /* List<User> list  = userService.queryAll();
        for(User u:list){
            System.out.println(u);
        }*/
       User user = userService.login("张三","123456");
        System.out.println(user);
    }


}
