package com.qrocode.service;

import com.qrocode.entity.Student;

import java.util.List;

/**
 * Author: Sandeep Singh
 * Date: 04/04/25
 */

public interface StudentService {
    Student addStudent(Student student);

    List<Student> getAllStudent();

    Student findById(String id);

    void deleteById(String id);
}

