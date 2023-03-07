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

@Service //걍 빈 등록
public class CourseService {

    private final CourseRepository courseRepository; //데이터베이스와 연결 ! (포함관계 > 상속개념)

    @Autowired  //생성자 주입 bean 객체있니? 넣어줘 ! (new 로 만들지 않음 ) / 1개만 있을 때는 생략 가능
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    //강의 생성
    @Transactional  //데이터베이스관점에서 먼저 공부후 쓰임새 공부하기
    public CourseResponseDto createCourse(CourseRequestDto courseRequestDto) {
        Course course = new Course(courseRequestDto);  //course 객체를 통해 database 접근
        return new CourseResponseDto(courseRepository.save(course));  //변환하면서 반환까지 !
    }

    //특정 강의 정보 요청
    public CourseResponseDto getCourse(Long id) {
        Course course = checkCourse(id);
        return new CourseResponseDto(course);
    }

    // 강의 목록 조회 요청
    public List<CourseResponseDto> getCourseList() {
        List<CourseResponseDto> courseResponseDtoList = new ArrayList<>();  //controller 반환타입이랑 맞춰주기 위해

        List<Course> courseList = courseRepository.findAll(); //데이터를 통해 courseList 전부 가져온다
        for (Course course : courseList) {  //향상된 for 문 > courseList 에서 course 를 하나씩 뽑아온다
            courseResponseDtoList.add(new CourseResponseDto(course)); //CourseResponseDto 타입으로 추가해준다
        }
        return courseResponseDtoList;
    }
    // 특정 강의 정보 수정 요청
    @Transactional
    public CourseResponseDto updateCourse(Long id, CourseRequestDto courseRequestDto) {
        Course course = checkCourse(id);
        course.update(courseRequestDto); //update 는 단순한 메서드이다 (영속성전이 원리를 이해하면 알 수 있다)
        return new CourseResponseDto(course);  //responseDto 타입으로 바꿔서 반환
    }
    // 특정 강의 삭제 요청
    @Transactional
    public String deleteCourse(Long id) {
        Course course = checkCourse(id);
        courseRepository.delete(course);
        return course.getTitle() + " 강의 삭제 성공"; //반환타입이 string
    }

    private Course checkCourse(Long id) {  //클래스 내부에서만 중복처리 개선메소드 > private
        return courseRepository.findById(id).orElseThrow(   //반환타입이 optional 타입 > 예외처리 필요 !
                () -> new NullPointerException("일치하는 강의 없음"));
    }
}














