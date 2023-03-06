package com.example.jpabasiclivelecture230305.service;

import com.example.jpabasiclivelecture230305.entity.Course;
import com.example.jpabasiclivelecture230305.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class CourseService {

    private final CourseRepository courseRepository;

    public void update() {
        Course course = courseRepository.findById(1L).orElseThrow(
                () -> new NullPointerException("강의 없음")
        );

        course.setTitle("Spring Update");
        course.setCost(12345.);
    }

}
