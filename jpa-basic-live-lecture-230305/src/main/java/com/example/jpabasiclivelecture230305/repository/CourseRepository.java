package com.example.jpabasiclivelecture230305.repository;

import com.example.jpabasiclivelecture230305.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {
    List<Course> findAllByInstructors(String inst);
}
