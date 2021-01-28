package com.melvin.dao;


import com.melvin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface UserMapper {
    //查询全部
    List<User> getUserList();
    //根据id查询user
    User getUserById(@Param("id") int id);
    //增加一个user
    int addUser(@Param("user") User user);
    //修改用户
    int updateUser(@Param("user") User user);
    //根据id删除用户
    int deleteUser(@Param("id") int id);
}
