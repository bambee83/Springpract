package com.example.jpabasiclivelecture230305;

import com.example.jpabasiclivelecture230305.entity.Course;
import com.example.jpabasiclivelecture230305.repository.CourseRawRepository;
import com.example.jpabasiclivelecture230305.repository.CourseRepository;
import com.example.jpabasiclivelecture230305.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class JpaBasicLiveLecture230305Application {

    public static void main(String[] args) {
        SpringApplication.run(JpaBasicLiveLecture230305Application.class, args);
    }

    @Autowired
    CourseRawRepository courseRawRepository;  // 등록된 빈을 필드주입

    @Autowired
    CourseRepository courseRepository;

    @Autowired
    CourseService courseService;

    @Bean
    ApplicationRunner applicationRunner() {
        return args -> {
            // Raw JPA
            // 등록 > 비영속 상태임
//            Course course = new Course();
//            course.setId(1L);
//            course.setTitle("JPA");
//            course.setInstructors("robbie");
//            course.setCost(100000.0);
                // 영속화
//            courseRawRepository.save(course);

            // 조회
//            Course course = courseRawRepository.findById(1L).orElseThrow(
//                    () -> new NullPointerException("강의 없음")
//            );
//            System.out.println("강의 제목 = " + course.getTitle());
//            System.out.println("수강료 = " + course.getCost());


            // 수정
//            courseRawRepository.updateCost(1L, 99999);

            // 삭제
//            courseRawRepository.delete(1L);


            // Spring Data JPA
            // 등록 >> 등록할때 왜 Hibernate 에서 select 문을 날릴까?
//            Course course = new Course();
//            course.setId(1L);
//            course.setTitle("Spring");
//            course.setInstructors("robbie");
//            course.setCost(9000.0);
//
//            courseRepository.save(course);

            // 조회
//            Course course = courseRepository.findById(1L).orElseThrow(
//                    () -> new NullPointerException("강의 없음")
//            );
//            System.out.println("강의 제목: " + course.getTitle());
//            System.out.println("수강료: " + course.getCost());


            // 수정
//            Course course = courseRepository.findById(1L).orElseThrow(
//                    () -> new NullPointerException("강의 없음")
//            );
//
//            course.setTitle("Spring Update");
//            course.setCost(2333329.);
//            courseRepository.save(course); // save 메서드를 호출해 직접 update 수행

            // 변경 감지 조건
            // 1. 변경하려는 Entity 객체가 영속 상태여야 합니다.
            // 2. 트랜잭션 안에 묶여 있어야 합니다.
            // 3. 트랜잭션이 commit 되어야 합니다. (flush 작동을 위해)

            // @Transactional
            // AOP 로 동작하기 때문에 Bean 으로 등록된 객체에만 적용 가능!

            // 외부 Bean 등록 객체를 통해 변경감지 Test
//            courseService.update();


            // 삭제
//            Course course = courseRepository.findById(1L).orElseThrow(
//                    () -> new NullPointerException("강의 없음")
//            );
//
//
//            courseRepository.delete(course);

        };
    }
}
