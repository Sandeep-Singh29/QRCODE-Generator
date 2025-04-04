package com.qrocode.controller;

import com.qrocode.entity.Student;
import com.qrocode.qrcodeservice.QRCodeGenerator;
import com.qrocode.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Author: Sandeep Singh
 * Date: 04/04/25
 */

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> addStudent(@RequestBody Student student) {
        return new ResponseEntity<>(studentService.addStudent(student), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        List<Student> students = studentService.getAllStudent();
        if (!students.isEmpty()) {
            for (Student student : students) {
                QRCodeGenerator.generateQrCode(student);
            }
        }
        return ResponseEntity.ok(studentService.getAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> findById(@PathVariable String id) {
        return ResponseEntity.ok(studentService.findById(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable String id) {
        studentService.deleteById(id);
        return ResponseEntity.noContent().build();
    }


}
