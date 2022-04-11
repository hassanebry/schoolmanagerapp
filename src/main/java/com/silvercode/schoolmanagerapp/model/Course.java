package com.silvercode.schoolmanagerapp.model;

import lombok.*;

import javax.persistence.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Course {

    @Id
    @SequenceGenerator(name = "course_id", sequenceName = "course_id", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "course_id")
    private Long courseId;
    private String courseName;
    private String department;

}
