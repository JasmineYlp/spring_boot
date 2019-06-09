package com.ctbu.edu.cn.web_test.service.impl;

import com.ctbu.edu.cn.web_test.dao.StudentRepository;
import com.ctbu.edu.cn.web_test.domain.Student;
import com.ctbu.edu.cn.web_test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class StudentImplService implements StudentService {
    @Autowired
    StudentRepository studentRepository;

    /*
     * 读取所有学生在数据
     * */
    public List<Student> findAll(){

        return studentRepository.findAll();

    }

    /**
     * 只支持分页的查询
     * @param pageable
     * @return
     */
    public  Page<Student> findAll(Pageable pageable){
        return studentRepository.findAll(pageable);
    }

    /**
     * 分页，带过滤的查询
     * @param student
     * @return
     */
    public Page<Student> findAll( Example<Student> student, Pageable pageable){
        return studentRepository.findAll(student,pageable);
    }

    /*
    插入学生
     */
    public Student insert(Student student){
        return studentRepository.save(student);
    }

    /*
    更新学生
     */
    public Student update(Student student){
        return studentRepository.save(student);
    }

    /*
   删除学生
    */
    public void delete(Student student){

        studentRepository.delete(student);
    }

    public void delete(Long id){
        Student student=new Student();
        student.setId(id);
        studentRepository.delete(student);
    }

    public Student getById(Long id){
        Student student=studentRepository.findById(id).orElse(null);
        return student;
    }
}
