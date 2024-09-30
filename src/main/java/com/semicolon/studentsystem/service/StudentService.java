package com.semicolon.studentsystem.service;

import com.semicolon.studentsystem.model.Student;

import java.util.List;

public interface StudentService  {
    public Student saveStudent(Student student);

    List<Student> getAllStudents();
}
