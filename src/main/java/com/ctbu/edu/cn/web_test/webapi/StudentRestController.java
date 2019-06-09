package com.ctbu.edu.cn.web_test.webapi;

import com.ctbu.edu.cn.web_test.core.PageUtils;
import com.ctbu.edu.cn.web_test.domain.Student;
import com.ctbu.edu.cn.web_test.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/webapi/student")
public class StudentRestController {

    @Autowired
    private StudentService studentService;

    /**
     * 读取的url
     * @return
     */
    @GetMapping("/list")
    public List<Student> getAll(){
        List<Student> students=studentService.findAll();
        return students;
    }

    /**
     * 分页，读取全部内容
     * @return
     */
    @GetMapping("/getbypage")
    public PageUtils getByPage(@RequestParam(value = "page",defaultValue = "0") Integer page,
                               @RequestParam(value="size",defaultValue = "10") Integer size,
                               @RequestParam(value = "name",defaultValue = "") String name){

        //按id排序
        Sort sort=new Sort(Sort.Direction.DESC,"id");

        Page<Student> studentPage;
        if(StringUtils.isEmpty(name)){
            Pageable pageable=PageRequest.of(page,size,sort);
            studentPage=studentService.findAll(pageable);
        }else{
            Student student=new Student();
            student.setName(name);

            Pageable pageable=PageRequest.of(0,10,sort);
            ExampleMatcher matcher=ExampleMatcher.matching()
                    .withMatcher("name",ExampleMatcher.GenericPropertyMatchers.contains());

            Example<Student> example=Example.of(student,matcher);

            studentPage = studentService.findAll(example, pageable);
        }

        PageUtils pageUtils=new PageUtils(studentPage.getContent(),studentPage.getTotalElements());

        return pageUtils;

    }

    /**
     * 读取的url
     * @return
     */
    @GetMapping("/get/{id}")
    public Student get(@PathVariable Long id){
        Student student=studentService.getById(id);
        student.setPassword("");
        return student;
    }

    /*
    插入学生
     */
    @PostMapping("/insert")
    public Student insert(Student student){
        Student student1=studentService.insert(student);
        return student1;
    }

    /*
    更新学生
     */
    @PutMapping("/update")
    public Student update(Student student){

        //读取旧的数据
        Student oldstudent=studentService.getById(student.getId());
        if(StringUtils.isEmpty(student.getPassword())){
            //没有新密码，那么就用旧密码
            student.setPassword(oldstudent.getPassword());

        }

        student=studentService.update(student);
        return student;
    }

    /*
    删除学生
     */
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){

        studentService.delete(id);
    }
}
