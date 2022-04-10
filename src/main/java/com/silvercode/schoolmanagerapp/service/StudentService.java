package com.silvercode.schoolmanagerapp.service;


import com.silvercode.schoolmanagerapp.dtos.StudentRequest;
import com.silvercode.schoolmanagerapp.exceptions.EmailAlreadyTakenException;
import com.silvercode.schoolmanagerapp.model.Student;
import com.silvercode.schoolmanagerapp.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public void createUser(StudentRequest studentRequest) throws EmailAlreadyTakenException {
        Optional<Student> studentOptional = studentRepository.findByEmail(studentRequest.getEmail());
        if (studentOptional.isPresent()){
            throw new EmailAlreadyTakenException("This email is already taken");
        }
        studentRepository.save(Student.builder()
                .firstName(studentRequest.getFirstName())
                .lastName(studentRequest.getLastName())
                .email(studentRequest.getEmail())
                .age(studentRequest.getAge()).build()
        );
    }
}
