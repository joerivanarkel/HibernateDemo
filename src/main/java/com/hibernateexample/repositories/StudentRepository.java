package com.hibernateexample.repositories;

import com.hibernateexample.Student;

public class StudentRepository extends BaseRepository<Student> {

    public StudentRepository() {
        super(Student.class);
    }

}