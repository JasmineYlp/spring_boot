package com.ctbu.edu.cn.web_test.service;

import com.ctbu.edu.cn.web_test.domain.Student;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.*;
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

    @Test
    public void insert() {
        Student student=new Student();
        student.setName("赵柳");
        student.setPassword("000");
        student.setScore(87);
        student.setSex(1);

        Student student1=studentService.insert(student);
        assertNotNull(student1.getId());
    }

    @Test
    public void update() {
        Student student=studentService.getById(5L);
        student.setName("赵柳2");
        studentService.update(student);

    }

    @Test
    public void filterByName(){

        Student student=new Student();
        student.setName("李赞");

        Sort sort=new Sort(Sort.Direction.DESC,"id");
        Pageable pageable= PageRequest.of(0,10,sort);

        ExampleMatcher matcher=ExampleMatcher.matching()
                .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains());

        Example<Student> example=Example.of(student,matcher);

        //Example<Student> example=Example.of(student);
        Page<Student> studentPage=studentService.findAll(example,pageable);

        System.out.println(studentPage);
    }
}