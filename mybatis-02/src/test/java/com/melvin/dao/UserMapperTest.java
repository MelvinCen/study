package com.melvin.dao;

import com.melvin.pojo.User;
import com.melvin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    @Test
    public void test() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //方式一：（推荐）
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();

        //方式二
        //List<User> userList = sqlSession.selectList("com.melvin.com.melvin.dao.UserDao.getUserList");

        for (User user : userList) {
            System.out.println(user);
        }

        sqlSession.close();


    }

    @Test
    public void getUserById() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();


    }
    //增删改需要提交事务
    @Test
    public void addUser() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(4);
        user.setName("哈哈");
        user.setPwd("123444");
        int result = mapper.addUser(user);
        if (result > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
        //事务提交!!!!!
        sqlSession.commit();
        sqlSession.close();


    }

    //增删改需要提交事务
    @Test
    public void updateUser() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(4);
        user.setName("哈哈更改");
        user.setPwd("123123");
        int result = mapper.updateUser(user);
        if (result > 0) {
            System.out.println("更新成功");
        } else {
            System.out.println("更新失败");
        }
        //事务提交!!!!!
        sqlSession.commit();
        sqlSession.close();


    }

    //增删改需要提交事务
    @Test
    public void deleteUser() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int result = mapper.deleteUser(4);
        if (result > 0) {
            System.out.println("删除成功");
        } else {
            System.out.println("删除失败");
        }
        //事务提交!!!!!
        sqlSession.commit();
        sqlSession.close();


    }
}
