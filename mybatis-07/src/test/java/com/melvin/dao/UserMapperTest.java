package com.melvin.dao;

import com.melvin.pojo.Student;
import com.melvin.pojo.Teacher;
import com.melvin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void getTeachers() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        Teacher teacher = mapper.getTeacherById2(1);
        System.out.println(teacher);


        sqlSession.close();
    }





}
