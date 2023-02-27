package com.example.springmvclivelecture230226.entity;

import lombok.*;

@Getter
@ToString
public class Course {
    private Long id;
    private String title;
    private String instructors;
    private Double cost;

    public void setId(Long id) {
        this.id = id;
    }

    public void setCourse(Course course) {
        this.title = course.getTitle();
        this.instructors = course.getInstructors();
        this.cost = course.getCost();
    }
}
