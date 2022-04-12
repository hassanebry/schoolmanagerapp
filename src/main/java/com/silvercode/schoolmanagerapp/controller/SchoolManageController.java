package com.silvercode.schoolmanagerapp.controller;


import com.silvercode.schoolmanagerapp.dtos.BookRequest;
import com.silvercode.schoolmanagerapp.dtos.CourseRequest;
import com.silvercode.schoolmanagerapp.dtos.StudentRequest;
import com.silvercode.schoolmanagerapp.model.Book;
import com.silvercode.schoolmanagerapp.model.Course;
import com.silvercode.schoolmanagerapp.model.Student;
import com.silvercode.schoolmanagerapp.service.BookService;
import com.silvercode.schoolmanagerapp.service.CourseService;
import com.silvercode.schoolmanagerapp.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/schoolmanage")
@AllArgsConstructor
public class SchoolManageController {

    private final StudentService studentService;
    private final BookService bookService;
    private final CourseService courseService;

    @PostMapping(path = "/student")
    public ResponseEntity<String> saveStudent(@RequestBody StudentRequest studentRequest, UriComponentsBuilder builder){
        studentService.createUser(studentRequest);
        return ResponseEntity.created(URI.create(builder.toUriString()+"/"+ UUID.randomUUID())).body("student saved !");
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

    @GetMapping(path = "/books")
    public ResponseEntity<List<Book>> getAllBooks(){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getAllBooks());
    }

    @PostMapping(path = "/book")
    public ResponseEntity<String> saveBook(@RequestBody BookRequest book, UriComponentsBuilder builder){
        bookService.createBook(book.getTitle());
        return ResponseEntity.created(URI.create(builder.toUriString()+"/"+ UUID.randomUUID())).body("book saved !");
    }

    @GetMapping(path = "/book/{bookId}")
    public ResponseEntity<Book> getBook(@PathVariable("bookId") Long bookId){
        return ResponseEntity.status(HttpStatus.OK).body(bookService.getBook(bookId));
    }

    @DeleteMapping(path = "/book/{bookId}")
    public ResponseEntity<String> deleteBook(@PathVariable("bookId") Long bookId) {
        bookService.deleteBook(bookId);
        return ResponseEntity.status(204).body("book deleted");
    }

    @PostMapping(path = "/student/{studentId}/book")
    public ResponseEntity<String> studentBuyingBook(
            @PathVariable("studentId") Long studentId,
            @RequestParam("bookId") Long bookId){
        bookService.assignBookToStudent(bookId, studentId);
        return ResponseEntity.status(HttpStatus.OK).body("achat effectué avec succès !");
    }

    @GetMapping(path = "/courses")
    public ResponseEntity<List<Course>> getAllCourses(){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getAllCourses());
    }

    @PostMapping(path = "/course")
    public ResponseEntity<String> saveCourse(@RequestBody CourseRequest courseRequest, UriComponentsBuilder builder){
        courseService.createCourse(courseRequest);
        return ResponseEntity.created(URI.create(builder.toUriString()+"/"+ UUID.randomUUID())).body("course saved !");
    }

    @GetMapping(path = "/course/{courseName}")
    public ResponseEntity<Course> getCourseByName(@PathVariable("courseName") String courseName){
        return ResponseEntity.status(HttpStatus.OK).body(courseService.getCourseByName(courseName));
    }

    @DeleteMapping(path = "/course/{courseId}")
    public ResponseEntity<String> deleteCourse(@PathVariable("courseId") Long courseId) {
        bookService.deleteBook(courseId);
        return ResponseEntity.status(204).body("course deleted");
    }

    @PostMapping(path="/student/{studentId}/course")
    public ResponseEntity<String> studentEnrolCourse(
            @PathVariable("studentId") Long studentId,
            @RequestParam("courseId") Long courseId){
        studentService.enrollingCourse(studentId, courseId);
        return ResponseEntity.ok("Enrolement done !");
    }



}
