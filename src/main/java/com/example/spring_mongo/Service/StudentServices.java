package com.example.spring_mongo.Service;

import com.example.spring_mongo.Entity.Student;
import com.example.spring_mongo.Repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServices {

    @Autowired
    private StudentRepo studentRepo;
    public void saveOrUpdate(Student student){

        studentRepo.save(student);
    }

    public Iterable<Student> listAll() {

        return this.studentRepo.findAll();
    }

    public void delete(String id) {

        studentRepo.deleteById(id);
    }

    public Student getStudentById(String id) {
        return studentRepo.findById(id).get();
    }
}
