package com.example.springmvclivelecture230226.entity;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CourseList {

    private static final List<Course> courseList = new ArrayList<>();

    // 강의 목록 조회
    public List<Course> getCourserList() {
        return courseList;
    }

    // 강의 등록
    public Course setCourseList(Course course) {
        if(courseList.size() != 0) {
            course.setId(courseList.get(courseList.size()-1).getId() + 1);
        } else {
            course.setId(1L);
        }

        courseList.add(course);
        return course;
    }

    // 특정 강의 조회
    public Course findCourse(Long id) {
        return checkCourse(id);
    }

    // 특정 강의 수정
    public Course updateCourse(Long id, Course course) {
        Course findCourse = checkCourse(id);
        if(findCourse != null) {
            findCourse.setCourse(course);
        }
        return findCourse;
    }

    // 특정 강의 삭제
    public List<Course> deleteCourse(Long id) {
        Course findCourse = checkCourse(id);
        if(findCourse != null) {
            courseList.remove(findCourse);
        }
        return courseList;
    }

    // List 에서 특정 강의 유무 확인
    private Course checkCourse(Long id) {
        for (Course course : courseList) {
            if(course.getId().equals(id)) {
                return course;
            }
        }
        return null;
    }

}
