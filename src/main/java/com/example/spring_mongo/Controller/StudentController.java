package com.example.spring_mongo.Controller;

import com.example.spring_mongo.Entity.Student;
import com.example.spring_mongo.Service.StudentServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:4200")
//@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/student")
public class StudentController {

    @Autowired
    public StudentServices studentServices;

    @PostMapping(value = "/save")
    public String saveStudent(@RequestBody Student student){


        studentServices.saveOrUpdate(student);
        return student.getId();
    }
    //@CrossOrigin(origins = "http://localhost:4200")
    @GetMapping(value = "/getAll")
    public Iterable<Student> getStudents(){

        return studentServices.listAll();
    }
    @PutMapping(value = "/edit/{id}")
    public Student update(@RequestBody Student student, @PathVariable(name="id") String id){

        student.setId(id);
        studentServices.saveOrUpdate(student);

        return  student;
    }
    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") String id){

        studentServices.delete(id);
    }
    @RequestMapping("/student/{id}")
    public Student getStudent(@PathVariable(name="id") String id){

        return studentServices.getStudentById(id);
    }

}
