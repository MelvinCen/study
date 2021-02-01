package com.melvin.dao;

import com.melvin.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    User getUserById(@Param("id")int id);
}
