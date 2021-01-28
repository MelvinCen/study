package com.melvin.dao;


import com.melvin.pojo.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //根据id查询user
    User getUserById(@Param("id") int id);

}
