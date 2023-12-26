package com.example.spring_mongo.Repo;

import com.example.spring_mongo.Entity.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends MongoRepository<Student, String>{
}
