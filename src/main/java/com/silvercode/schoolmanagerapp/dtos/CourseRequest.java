package com.silvercode.schoolmanagerapp.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CourseRequest {
    private String courseName;
    private String department;
}
