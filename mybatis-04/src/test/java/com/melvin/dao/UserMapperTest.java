package com.melvin.dao;

import com.melvin.pojo.User;
import com.melvin.utils.MyBatisUtils;
import com.sun.javafx.collections.MappingChange;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {

    private Logger logger = Logger.getLogger(UserMapperTest.class);
    @Test
    public void getUserById() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);
        sqlSession.close();


    }

    @Test
    public void getUserByLimit() {
        logger.info("进入getUserByLimit方法");
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String,Object> params = new HashMap<String, Object>();
        params.put("offset",0);
        params.put("size",2);

        List<User> users = mapper.getUserByLimit(params);
        logger.info("getUserByLimit方法获取到数据库值 - " + users);
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

    @Test
    public void getUserByRowBounds() {
        logger.info("进入getUserByRowBounds方法");
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        RowBounds rowBounds = new RowBounds(0,2);
        List<User> users = sqlSession.selectList("com.melvin.com.melvin.dao.UserMapper.getUserByRowBounds",null,rowBounds);
        logger.info("getUserByRowBounds方法获取到数据库值 - " + users);
        for (User user : users) {
            System.out.println(user);
        }

        sqlSession.close();
    }

}
