package com.silvercode.schoolmanagerapp.controller;


import com.silvercode.schoolmanagerapp.dtos.StudentRequest;
import com.silvercode.schoolmanagerapp.model.Student;
import com.silvercode.schoolmanagerapp.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/schoolmanage")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @PostMapping(path = "/student")
    public ResponseEntity<String> saveStudent(@RequestBody StudentRequest studentRequest, UriComponentsBuilder builder){
        studentService.createUser(studentRequest);
        return ResponseEntity.created(URI.create(builder.toUriString()+"/"+ studentRequest.getEmail())).body("student saved !");
    }

    @GetMapping(path = "/students")
    public ResponseEntity<List<Student>> getAllStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getAllStudents());
    }

    @GetMapping(path = "/student/{email}")
    public ResponseEntity<Student> getStudentByEmail(@PathVariable("email") String email){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudentByEmail(email));
    }

    @DeleteMapping(path = "/student/{studentId}")
    public ResponseEntity<String> deleteStudent(@PathVariable("studentId") Long studentId){
        studentService.deleteStudent(studentId);
        return ResponseEntity.status(204).body("student deleted");
    }



}
