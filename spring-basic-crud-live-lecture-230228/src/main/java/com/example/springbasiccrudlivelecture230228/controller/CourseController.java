package com.example.springbasiccrudlivelecture230228.controller;


import com.example.springbasiccrudlivelecture230228.dto.CourseRequestDto;
import com.example.springbasiccrudlivelecture230228.dto.CourseResponseDto;
import com.example.springbasiccrudlivelecture230228.entity.Course;
import com.example.springbasiccrudlivelecture230228.entity.CourseList;
import com.example.springbasiccrudlivelecture230228.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //디스패쳐서블릿에 의해서 http 프로토콜을 받아주는 역할
@RequestMapping("/course")
public class CourseController {

    private final CourseService courseService;
    private final CourseList courseList;  //여러개 연결 가능

    @Autowired  //bean 객체를 받아온다 (보통 1개일 때는 생략 가능 )  생성자를 통한 필드주입
    public CourseController(CourseService courseService, CourseList courseList) {
        this.courseService = courseService;
        this.courseList = courseList;
    }

    // 강의 생성 요청
    @PostMapping("/create")
    public CourseResponseDto createCourse(@RequestBody CourseRequestDto courseRequestDto) {
        return courseService.createCourse(courseRequestDto);}

    // 특정 강의 정보 요청
    @GetMapping("/{id}")
    public CourseResponseDto getCourse(@PathVariable Long id) {
        return courseService.getCourse(id);
    }

    // 강의 목록 조회 요청
    @GetMapping("/list")
    public List<CourseResponseDto> getCourseList() {
        return courseService. getCourseList();
    }

    // 특정 강의 정보 수정 요청
    @PutMapping("/update")
    public CourseResponseDto updateCourse(@RequestParam Long id, @RequestBody CourseRequestDto courseRequestDto) {
        return courseService.updateCourse(id, courseRequestDto); } //받아온 거 다 넘겨주기

    // 특정 강의 삭제 요청
    @DeleteMapping("/delete")
    public String deleteCourse(@RequestParam Long id) {
        return courseService.deleteCourse(id);}


    @PostMapping("/db-test")  //courslist  통한 접근 ! > jpa를 통한 접근으로 추적불가능
    public void databaseConnectionExample(@RequestBody Course course) {
        courseList.databaseConnectionExample(course);}
}