package com.melvin.dao;

import com.melvin.pojo.Student;
import com.melvin.utils.MyBatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

public class UserMapperTest {

    @Test
    public void getStudents() {

        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = studentMapper.getStudents();
        for (Student student : students) {
            System.out.println(student);
        }

        sqlSession.close();
    }



}
