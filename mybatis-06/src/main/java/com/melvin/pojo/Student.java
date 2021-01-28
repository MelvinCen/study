package com.melvin.pojo;

import com.melvin.pojo.Teacher;
import lombok.Data;

@Data
public class Student {
    private Integer id;
    private String name;
    private Teacher teacher;
}
