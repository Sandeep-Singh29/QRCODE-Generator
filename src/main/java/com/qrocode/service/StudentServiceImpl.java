package com.qrocode.service;

import com.qrocode.entity.Student;
import com.qrocode.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Author: Sandeep Singh
 * Date: 04/04/25
 */

@Service
@RequiredArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;


    @Override
    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public Student findById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found."));
    }

    @Override
    public void deleteById(String id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Student not found."));
        if (student == null) {
            throw new EntityNotFoundException("Student not found.");
        }
        studentRepository.deleteById(id);
    }
}
