package com.silvercode.schoolmanagerapp.model;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    @Id
    @SequenceGenerator(name = "student_id", sequenceName = "student_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id")
    private Long studentId;
    private String firstName;
    private String lastName;
    private String email;
    private Integer age;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "enrolment",
            joinColumns = @JoinColumn(name = "student_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> enroledAt;

    @OneToMany(mappedBy = "student", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Book> books = new HashSet<>();

    public Student(String firstName, String lastName, String email, Integer age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.age = age;
    }

    public void addBook(Book book){
        this.books.add(book);
    }

}
