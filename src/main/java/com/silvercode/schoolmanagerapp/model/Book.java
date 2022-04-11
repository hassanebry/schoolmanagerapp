package com.silvercode.schoolmanagerapp.model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;


@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Book{
    @Id
    @SequenceGenerator(name = "book_id", sequenceName = "book_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "book_id")
    private Long bookId;
    private String title;
    private LocalDate createdAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id")
    private Student student;

    public Book(String title) {
        this.title = title;
        this.createdAt = LocalDate.now();
    }

    public Long getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public Student getStudent() {
        return null;
    }
}
