package com.melvin.dao;

import com.melvin.pojo.User;
import com.melvin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

public class TestCase {

    @Test
    public void getUserById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        System.out.println("====================");
        User user2 = mapper.getUserById(1);
        System.out.println(user2);
        System.out.println(user == user2);
        sqlSession.close();

    }
}
