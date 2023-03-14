package com.example.jpabasiclivelecture230305.repository;

import com.example.jpabasiclivelecture230305.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> { //id 는 롱타입
    List<Course> findAllByInstructors(String inst);   // 안에 들어갈 매개변수 내놔라 !!
}
