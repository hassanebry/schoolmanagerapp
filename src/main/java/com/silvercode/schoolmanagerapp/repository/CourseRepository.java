package com.silvercode.schoolmanagerapp.repository;

import com.silvercode.schoolmanagerapp.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {

    @Query("select c from Course c where c.courseName =?1 ")
    Course findByCourseName(String courseName);
}
