package com.example.springbasiccrudlivelecture230228.repository;

import com.example.springbasiccrudlivelecture230228.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, Long> {  //레포지토리는 보통 인터페이스로 만든다
                                                                    // course 테이블에 접근할 수 있는 창구 생성 ,
                                                                    // 빈으로등록(@Repository 하지 않아도 상속받음으로 빈객체로 등록) > springboot 내의 옵션...
}
