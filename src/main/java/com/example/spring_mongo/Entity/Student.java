package com.example.spring_mongo.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document//(collation = "student")
public class Student {

    @Id
    private String id;

    private String student_name;
    private String student_address;
    private String mobile;

    public Student(String id, String student_name, String student_address, String mobile) {
        this.id = id;
        this.student_name = student_name;
        this.student_address = student_address;
        this.mobile = mobile;
    }

    public Student() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getStudent_address() {
        return student_address;
    }

    public void setStudent_address(String student_address) {
        this.student_address = student_address;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id='" + id + '\'' +
                ", student_name='" + student_name + '\'' +
                ", student_address='" + student_address + '\'' +
                ", mobile='" + mobile + '\'' +
                '}';
    }
}
