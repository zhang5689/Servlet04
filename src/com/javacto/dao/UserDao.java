package com.javacto.dao;

import com.javacto.po.User;

import java.util.List;

/**
 * describe
 * 作者：曾昭武  adam8831
 */
public interface UserDao {
    /**
     * 登陆
     * @param userName
     * @param pwd
     * @return
     */
    public   User login(String userName,String pwd);
    /**
     * 添加
     */
    public  int addUser(User user);

    /**
     * 删除
     */
    public  int deleteUser(int id);

    /**
     * 根据ID查询
     */
    public User findUserByID(int id);


    /**
     * 修改
     */
    public  int updateUser(User user);

    /**
     * 查询所有
     */
    public List<User> queryAll();
}
