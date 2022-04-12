package com.silvercode.schoolmanagerapp.service;

import com.silvercode.schoolmanagerapp.dtos.CourseRequest;
import com.silvercode.schoolmanagerapp.model.Course;
import com.silvercode.schoolmanagerapp.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CourseService {

    private final CourseRepository courseRepository;

    public List<Course> getAllCourses(){
        return courseRepository.findAll();
    }

    public void createCourse(CourseRequest courseRequest){
        courseRepository.save(Course.builder()
                .courseName(courseRequest.getCourseName())
                .department(courseRequest.getDepartment())
                .build());
    }

    public Course getCourseByName(String courseName){
        return courseRepository.findByCourseName(courseName);
    }

    public void deleteCourse(Long courseId){
        courseRepository.deleteById(courseId);
    }

}
