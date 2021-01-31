package com.melvin.pojo;

import lombok.Data;

import java.util.List;

@Data
public class Teacher {
    private Integer id;
    private String name;

    //一个老师拥有多个学生
    private List<Student> students;
}
