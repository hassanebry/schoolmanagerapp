package com.silvercode.schoolmanagerapp.controller;


import com.silvercode.schoolmanagerapp.dtos.StudentRequest;
import com.silvercode.schoolmanagerapp.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

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




}
