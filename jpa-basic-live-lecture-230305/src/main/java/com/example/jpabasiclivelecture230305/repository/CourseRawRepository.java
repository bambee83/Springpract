package com.example.jpabasiclivelecture230305.repository;

import com.example.jpabasiclivelecture230305.entity.Course;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Optional;

@Repository
public class CourseRawRepository {

    @PersistenceContext
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
        Course course = em.find(Course.class, id);
        return Optional.ofNullable(course);
    }

    // 강의 수정
    @Transactional
    public void updateCost(Long id, double cost) {
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
