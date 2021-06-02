package com.javacto.service;

import com.javacto.dao.UserDao;
import com.javacto.dao.UserDaoImpl;
import com.javacto.po.User;

import java.util.ArrayList;
import java.util.List;

/**
 * describe  业务实现类
 * 作者：曾昭武  adam8831
 */
public class UserServiceImpl implements UserService{
    //业务层需要调用dao层的方法   接口 变量名 = new 实现类();  new出来的对象只给当前类使用 加 private
    private  UserDao userDao = new UserDaoImpl();


    /**
     * 登陆
     * @param userName
     * @param pwd
     * @return
     */
    @Override
    public   User login(String userName,String pwd){
        return  userDao.login(userName,pwd);
    }
    /**
     * 添加
     */
    public  int addUser(User user){
        int num = 0;
        //调用方法
        num=userDao.addUser(user);
        return num;
    }

    /**
     * 删除
     */
    public  int deleteUser(int id){
        return userDao.deleteUser(id);
    }

    /**
     * 根据ID查询
     */
    public User findUserByID(int id){
        return userDao.findUserByID(id);
    }

    /**
     * 修改
     */
    public  int updateUser(User user){
        return userDao.updateUser(user);
    }

    /**
     * 查询所有
     */
    public List<User> queryAll(){
        return userDao.queryAll();
    }
}
