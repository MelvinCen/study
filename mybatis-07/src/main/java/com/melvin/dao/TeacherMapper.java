package com.melvin.dao;

import com.melvin.pojo.Teacher;
import org.apache.ibatis.annotations.Param;


public interface TeacherMapper {

    Teacher getTeacherById(@Param("tid")int tid);

    Teacher getTeacherById2(@Param("tid")int tid);
}
