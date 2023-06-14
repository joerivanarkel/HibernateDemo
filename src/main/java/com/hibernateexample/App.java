package com.hibernateexample;

import java.util.List;

import com.hibernateexample.repositories.StudentRepository;


public class App {

    public static void main(String[] args) {

        StudentRepository studentRepository = new StudentRepository();

        // test saveStudent
        Student student = new Student("Ramesh", "Fadatare", "ramesh@gmail.com");
        studentRepository.save(student);

        // test updateStudent
        // student.setFirstName("Ram");
        // studentRepository.update(student);

        // // test getStudentById
        // Student student2 = studentRepository.getById(student.getId());

        // test getAllStudents
        // List < Student > students = studentRepository.getAll();
        // for (Student student1: students) {
        //     System.out.println(student1.getFirstName());
        // }

        // test deleteStudent
        studentRepository.delete(student.getId());

    }
}