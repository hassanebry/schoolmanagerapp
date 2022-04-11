package com.silvercode.schoolmanagerapp.service;


import com.silvercode.schoolmanagerapp.exceptions.BookDoesNotExistsException;
import com.silvercode.schoolmanagerapp.exceptions.StudentDoesNotExistException;
import com.silvercode.schoolmanagerapp.model.Book;
import com.silvercode.schoolmanagerapp.model.Student;
import com.silvercode.schoolmanagerapp.repository.BookRepository;
import com.silvercode.schoolmanagerapp.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final StudentRepository studentRepository;

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public void createBook(String title){
        bookRepository.save(new Book(title));
    }

    public Book getBook(Long bookId){
        return bookRepository.findAll().stream()
                .filter(p -> p.getBookId().equals(bookId))
                .findFirst()
                .orElseThrow(()->new BookDoesNotExistsException("The book doesnt exist"));
    }

    public void deleteBook(Long bookId){
        bookRepository.deleteById(bookId);
    }

    public void assignBookToStudent(Long bookId, Long studentId){
        Book book = bookRepository.findById(bookId).orElseThrow(()->new BookDoesNotExistsException("the book doesnt exist"));
        Student student = studentRepository.findById(studentId).orElseThrow(()->new StudentDoesNotExistException("student absent"));

        book.setStudent(student);
        bookRepository.save(book);
    }



}
