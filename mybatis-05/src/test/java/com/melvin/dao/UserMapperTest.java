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
    public void getUsers() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = mapper.getUserList();
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

    @Test
    public void addUser() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = new User();
        user.setId(5);
        user.setName("five");
        user.setPassword("111111");
        int result = mapper.addUser(user);
        if (result > 0) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
        sqlSession.close();
    }

}
