package com.silvercode.schoolmanagerapp.service;


import com.silvercode.schoolmanagerapp.dtos.StudentRequest;
import com.silvercode.schoolmanagerapp.exceptions.CourseDoesntExistsException;
import com.silvercode.schoolmanagerapp.exceptions.EmailAlreadyTakenException;
import com.silvercode.schoolmanagerapp.exceptions.StudentDoesNotExistException;
import com.silvercode.schoolmanagerapp.model.Course;
import com.silvercode.schoolmanagerapp.model.Student;
import com.silvercode.schoolmanagerapp.repository.CourseRepository;
import com.silvercode.schoolmanagerapp.repository.StudentRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Slf4j
public class StudentService {

    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;

    public void createUser(StudentRequest studentRequest) throws EmailAlreadyTakenException {
        Optional<Student> studentOptional = studentRepository.findByEmail(studentRequest.getEmail());
        if (studentOptional.isPresent()){
            throw new EmailAlreadyTakenException("This email is already taken");
        }
        studentRepository.save(
                new Student(studentRequest.getFirstName(),
                        studentRequest.getLastName(),
                        studentRequest.getEmail(),
                        studentRequest.getAge()));

    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentByEmail(String email){
        return studentRepository.findAll().stream()
                .filter(p -> p.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new StudentDoesNotExistException("This student does not exist"));

    }

    public void deleteStudent(Long studentId){
        studentRepository.deleteById(studentId);
    }

    public void enrollingCourse(Long studentId, Long courseId){
        Student student = studentRepository.findById(studentId).orElseThrow(()->new StudentDoesNotExistException("student absent"));
        Course course = courseRepository.findById(courseId).orElseThrow(()->new CourseDoesntExistsException("course absent"));

        List<Course> enrollements = student.getEnroledAt();
        enrollements.add(course);
        studentRepository.save(student);
    }

}
