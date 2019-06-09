package com.ctbu.edu.cn.web_test.service;

import com.ctbu.edu.cn.web_test.dao.StudentRepository;
import com.ctbu.edu.cn.web_test.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface StudentService {


    /*
     * 读取所有学生在数据
     * */
   List<Student> findAll();

    /**
     * 只支持分页的查询
     * @param pageable
     * @return
     */
   Page<Student> findAll(Pageable pageable);

    /**
     * 分页，带过滤的查询
     * @param student
     * @return
     */
  Page<Student> findAll(Example<Student> student,Pageable pageable);

   /*
    插入学生
     */
        Student insert(Student student);

    /*
    更新学生
     */
        Student update(Student student);

    /*
   删除学生
    */
        void delete(Student student);

        void delete(Long id);

        Student getById(Long id);
        }
