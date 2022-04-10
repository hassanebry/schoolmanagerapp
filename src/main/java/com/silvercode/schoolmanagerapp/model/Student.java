package com.silvercode.schoolmanagerapp.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

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

}
