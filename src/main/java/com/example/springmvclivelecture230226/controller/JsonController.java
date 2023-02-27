package com.example.springmvclivelecture230226.controller;

import com.example.springmvclivelecture230226.entity.Course;
import com.example.springmvclivelecture230226.entity.CourseList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")
public class JsonController {

    private final CourseList courseList;

    @Autowired
    public JsonController(CourseList courseList) {
        this.courseList = courseList;
    }

    // 강의 생성 요청
    @PostMapping("/create")
    public Course helloRequestPath(@RequestBody Course course) {
        System.out.println(course.toString());
        return courseList.setCourseList(course);
    }

    // 특정 강의 정보 요청 -> 강의 의 id 를 전달 받아서 처리
    @GetMapping("/{id}") // http://localhost:8080/course/2   => id = 2
    public Course getCourse(@PathVariable Long id) {
        System.out.println(
                "id: " + id
        );
        return courseList.findCourse(id);
    }

    // 저장된 강의 목록 조회 요청
    @GetMapping("/list")
    public List<Course> getCourseList() {
        return courseList.getCourserList();
    }

    // 특정 강의 정보 수정 요청 // http://localhost:8080/course/update?id=2, "{course 관련 json 데이터}"
    @PutMapping("/update") // 강의의 id, 수정될 강의 정보(body)
    public Course updateCourse(@RequestParam Long id, @RequestBody Course course) {
        System.out.println(
                "id: " + id
        );
        System.out.println(course.toString());
        return courseList.updateCourse(id, course);
    }

    // 특정 강의 삭제 요청
    @DeleteMapping("/delete")
    public List<Course>  deleteCourse(@RequestParam Long id) {
        System.out.println(
                "id: " + id
        );
        return courseList.deleteCourse(id);
    }










}
