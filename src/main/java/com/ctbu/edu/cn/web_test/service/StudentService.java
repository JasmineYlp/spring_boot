package com.ctbu.edu.cn.web_test.service;

import com.ctbu.edu.cn.web_test.dao.StudentRepository;
import com.ctbu.edu.cn.web_test.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    /*
     * 读取所有学生在数据
     * */
    public List<Student> findAll(){

        return studentRepository.findAll();

    }
}
