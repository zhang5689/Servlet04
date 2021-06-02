package com.javacto.dao;

import com.javacto.po.User;
import com.javacto.utils.BaseDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * describe
 * 作者：曾昭武  adam8831
 */
public class UserDaoImpl implements  UserDao{
    /**
     * 登陆
     * @param userName
     * @param pwd
     * @return
     */
    public   User login(String userName,String pwd){
        Connection conn= BaseDao.getCollections();
        PreparedStatement pstm =null;
        ResultSet rs =null;
        //我这里只会定义，不会创建
        User user = null;
        try {
            //3.处理预编译 SQL语句  ?代表占位符  ?一个问号代码一个变量，没有赋值
            String sql="SELECT * FROM TUSER WHERE t_name=? AND t_password=? ";
            pstm = conn.prepareStatement(sql);
            //4.如果SQL语句 有？ 号必需给? 赋值
            pstm.setObject(1,userName);
            pstm.setObject(2,pwd);
            //5.运行执行预编译 SQL语句 pstm.executeQuery(注意这里不能有SQL语句)
            rs = pstm.executeQuery();
            // 6.循环遍历
            while (rs.next()){
                //创建对象
                user = new User();
                user.setId(rs.getInt(1));
                user.setPwd(rs.getString(3));
                //Exception in thread "main" java.sql.SQLException: Column 'userName' not found. 查询语句列名不存在 必需与数据名一致
                //user.setUserName(rs.getString("userName"));//这个会报错
                user.setUserName(rs.getString("t_name"));
                user.setSex(rs.getString("t_sex"));
                //如果进来了，就知道这里有数据,
                System.out.println(rs.getInt("t_id")+"密码为:"+rs.getString(3)+"用户名为"+rs.getString(2));

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            BaseDao.closeAll(conn,pstm,rs);

        }

        return user;
    }

    /**
     * 添加  删除  修改每次只是SQL语句不一样， 还有传的参数不一样
     */
    /**
     * 添加
     */
    public  int addUser(User user){
        String sql = "INSERT INTO TUSER(t_name,t_password,t_sex,t_date,t_address,t_state) VALUES(?,?,?,NOW(),?,0)";
        Object sbqSbq[] = {user.getUserName(),user.getPwd(),user.getSex(),user.getAddress()};
        return BaseDao.myExecuteUpdate(sql,sbqSbq);
    }

    /**
     * 删除
     */
    public  int deleteUser(int id){
        String sql = "DELETE FROM TUSER WHERE t_id=?";
        Object sbqSbq[] = {id};
        return BaseDao.myExecuteUpdate(sql,sbqSbq);
    }
    /**
     * 修改
     */
    public  int updateUser(User user){
        String sql = "UPDATE   TUSER SET t_name=?,t_sex=? WHERE  t_id=?";
        Object sbqSbq[] = {user.getUserName(),user.getSex(),user.getId()};
        return BaseDao.myExecuteUpdate(sql,sbqSbq);
    }

    /**
     * 查询所有
     */
    public List<User> queryAll(){
        // 0必需创建集合对象
        List<User> list = new ArrayList<User>();
        Connection conn= null;
        PreparedStatement pstm =null;
        ResultSet rs =null;
        try {

            //ctrl +f
            conn= BaseDao.getCollections();
            //3.处理预编译 SQL语句  ?代表占位符  ?一个问号代码一个变量，没有赋值
            String sql="SELECT * FROM TUSER  ";
            pstm = conn.prepareStatement(sql);
            //4.如果SQL语句 有？ 号必需给? 赋值

            //5.运行执行预编译 SQL语句 pstm.executeQuery(注意这里不能有SQL语句)
            rs = pstm.executeQuery();
            // 6.循环遍历
            while (rs.next()){
                //这里面必需有3个步骤
                //1.必需在循环这里面创建对象
                User user1 = new User();
                //2.把值添加到User对象中
                user1.setId(rs.getInt("t_id"));
                user1.setUserName(rs.getString("t_name"));
                user1.setPwd(rs.getString(3));
                user1.setSex(rs.getString("t_sex"));
                user1.setAddress(rs.getString("t_address"));
                user1.setDate(rs.getDate(5));
                //3.把user1 add到集合中
                list.add(user1);

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            BaseDao.closeAll(conn,pstm,rs);
        }
        return list;
    }


    /**
     * 根据ID查询
     */
    public User findUserByID(int id){
        Connection conn= BaseDao.getCollections();
        PreparedStatement pstm =null;
        ResultSet rs =null;
        //我这里只会定义，不会创建
        User user = null;
        try {
            //3.处理预编译 SQL语句  ?代表占位符  ?一个问号代码一个变量，没有赋值
            String sql="SELECT * FROM TUSER WHERE t_id=?  ";
            pstm = conn.prepareStatement(sql);
            //4.如果SQL语句 有？ 号必需给? 赋值
            pstm.setObject(1,id);
            //5.运行执行预编译 SQL语句 pstm.executeQuery(注意这里不能有SQL语句)
            rs = pstm.executeQuery();
            // 6.循环遍历
            while (rs.next()){
                //创建对象
                user = new User();
                user.setId(rs.getInt(1));
                user.setPwd(rs.getString(3));
                //Exception in thread "main" java.sql.SQLException: Column 'userName' not found. 查询语句列名不存在 必需与数据名一致
                //user.setUserName(rs.getString("userName"));//这个会报错
                user.setUserName(rs.getString("t_name"));
                user.setSex(rs.getString("t_sex"));
                //如果进来了，就知道这里有数据,
                System.out.println(rs.getInt("t_id")+"密码为:"+rs.getString(3)+"用户名为"+rs.getString(2));

            }

        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //释放资源
            BaseDao.closeAll(conn,pstm,rs);

        }

        return user;
    }

}
