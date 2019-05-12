package com.ctbu.edu.cn.web_test.dao;

import com.ctbu.edu.cn.web_test.domain.Student;
import org.springframework.data.jpa.repository.JpaRepository;

/*
 * 学生仓库接口
 * */
public interface StudentRepository extends JpaRepository<Student, Long> {
}
