package com.ctbu.edu.cn.web_test.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;


/*
 * 学生实体
 * */
@Entity(name = "student")
@Data
public class Student {

    @Id
    @GeneratedValue
    private  long id;

    /*
     * 名称
     * */
    private String name;

    /*
     * 密码
     * */
    private String password;

    /*
     * 性别
     * */
    private Integer sex;

    /*
     * 学生成绩
     * */
    private  Integer score;
}