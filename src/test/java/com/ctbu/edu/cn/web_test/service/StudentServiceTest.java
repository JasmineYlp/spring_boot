package com.ctbu.edu.cn.web_test.service;

import com.ctbu.edu.cn.web_test.domain.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    StudentService studentService;

    @Test
    public void findAll() {

        List<Student> studentList=studentService.findAll();

        Assert.assertNotNull(studentList);
    }
}