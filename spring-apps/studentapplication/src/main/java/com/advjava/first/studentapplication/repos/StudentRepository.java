package com.advjava.first.studentapplication.repos;

import org.springframework.data.repository.CrudRepository;

import com.advjava.first.studentapplication.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer>{

}
