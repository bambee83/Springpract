package com.example.springbasiccrudlivelecture230228.entity;

import com.example.springbasiccrudlivelecture230228.dto.CourseRequestDto;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter //필드 가져가서 사용해야 함
@Entity // Course 를 테이블에 매핑하는 jpa 객체로 사용하겠다
@NoArgsConstructor // 파라미터가 없는 기본생성자 생성 (롬복패키지)
public class Course extends Timestamped {  //timestamped 상속 !

    @Id //pk로 사용
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 어떤 방식으로 관리할지 알려주는 거 나증에 공부하기 (auto 차이 면접때 나옴)
    private Long id;
    private String title;
    private String instructors;
    private Double cost;

    public Course(CourseRequestDto courseRequestDto) { //생성자 > service 단에서 쓰임, id는 자동으로 넣어짐
        this.title = courseRequestDto.getTitle();
        this.instructors = courseRequestDto.getInstructors();
        this.cost = courseRequestDto.getCost();
    }

    // 특정 강의 정보 수정 요청 > RequestDto 로 받아온거 변환해서 넘겨준다
    public void update(CourseRequestDto courseRequestDto) {  //매소드 > service 단에서 쓰임
        this.title = courseRequestDto.getTitle();
        this.instructors = courseRequestDto.getInstructors();
        this.cost = courseRequestDto.getCost();
    }

    // CourseList 에서 사용
    public void setId(Long id) {  //메서드를 통한 접근 !
        this.id = id;
    }

    public void setCourse(Course course) {
        this.title = course.getTitle();
        this.instructors = course.getInstructors();
        this.cost = course.getCost();
    }
}
