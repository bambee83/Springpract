package com.example.jpabasiclivelecture230305.repository;

import com.example.jpabasiclivelecture230305.entity.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class CourseRawRepository {

    @PersistenceContext //영속성 , 오토와이어같은거임
    EntityManager em;

    // 강의 등록
    @Transactional
    public void save(Course course) {
        //트랜잭션 시작
        em.persist(course);
        //트랜잭션 끝
    }

    // 강의 조회
    @Transactional
    public Optional<Course> findById(Long id) {
        Course course = em.find(Course.class, id);  //Course 라는 테이블에서 내가 보낸 id 값을 받아올거야
        return Optional.ofNullable(course);  //optional 공부하기 > nullPointException 처리해줘야 함
    }

    // 강의 수정
    @Transactional
    public void updateCost(Long id, double cost) {  // 아이디 받아오고 cost 바꿀거야
        // 수정할 강의 조회
        Course course = em.find(Course.class, id);

        course.setCost(cost);
    }

    // 강의 삭제
    @Transactional
    public void delete(Long id) {
        // 삭제할 강의 조회
        Course course = em.find(Course.class, id);

        em.remove(course);
    }

}
