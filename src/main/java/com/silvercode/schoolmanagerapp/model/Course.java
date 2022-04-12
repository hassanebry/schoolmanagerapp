package com.silvercode.schoolmanagerapp.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Builder
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

    @ManyToMany(mappedBy = "enroledAt")
    private List<Student> students;

    public Long getCourseId() {
        return courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getDepartment() {
        return department;
    }

    public List<Student> getStudents() {
        return null;
    }
}
