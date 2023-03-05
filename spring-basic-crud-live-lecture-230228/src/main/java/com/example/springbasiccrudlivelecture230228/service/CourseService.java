package com.example.springbasiccrudlivelecture230228.service;

import com.example.springbasiccrudlivelecture230228.dto.CourseRequestDto;
import com.example.springbasiccrudlivelecture230228.dto.CourseResponseDto;
import com.example.springbasiccrudlivelecture230228.entity.Course;
import com.example.springbasiccrudlivelecture230228.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CourseService {

    private final CourseRepository courseRepository;

    @Autowired
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }


    @Transactional  //데이터베이스관점에서 먼저 공부후 쓰임새 공부하기
    public CourseResponseDto createCourse(CourseRequestDto courseRequestDto) {
        Course course = new Course(courseRequestDto);
        return new CourseResponseDto(courseRepository.save(course));  //변환하면서 반환까지 !
    }


    public CourseResponseDto getCourse(Long id) {
        Course course = checkCourse(id);

        return new CourseResponseDto(course);
    }


    public List<CourseResponseDto> getCourseList() {
        List<CourseResponseDto> courseResponseDtoList = new ArrayList<>();

        List<Course> courseList = courseRepository.findAll();
        for (Course course : courseList) {  //향상된 for 문 > courselist 에서 course를 하나씩 뽑아온다
            courseResponseDtoList.add(new CourseResponseDto(course)); //repsonsedto 타입으로 추가해준다
        }

        return courseResponseDtoList;
    }


    @Transactional
    public CourseResponseDto updateCourse(Long id, CourseRequestDto courseRequestDto) {
        Course course = checkCourse(id);

        course.update(courseRequestDto); //영속성전이 원리를 이해하면 알 수 있다,

        return new CourseResponseDto(course);  //responsedto 타입으로 바꿔서 반환
    }


    @Transactional
    public String deleteCourse(Long id) {
        Course course = checkCourse(id);

        courseRepository.delete(course);

        return course.getTitle() + " 강의 삭제 성공"; //반환타입이 string
    }


    private Course checkCourse(Long id) {  //클래스 내부에서만 중복처리 개선메소드
        return courseRepository.findById(id).orElseThrow(   //반환타입이 optional 타입 > 예외처리 필요 !
                () -> new NullPointerException("일치하는 강의 없음")
        );
    }
}














