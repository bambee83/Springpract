package com.example.jpabasiclivelecture230305.entity;

import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.transaction.Transactional;

class CourseTest {

    // Spring 환경이기 때문에 아래 코드는 Error 가 발생하지만
    // persistence.xml 파일을 읽어오는 것과
    // JPA 의 raw 코드 확인
    // DB 와 마찬가지로 EntityManager를 통해 작업을 하기 위해서는 트랜잭션 환경이 필요하다.
    @Test
    @Transactional
    void test() {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        EntityManager em = emf.createEntityManager();

        EntityTransaction et = em.getTransaction();
        et.begin();

        try {

            Course course = new Course();
            course.setId(1L);
            course.setTitle("title");
            course.setInstructors("강사");
            course.setCost(10000.0);

            em.persist(course);

        }catch (Exception e){
            e.printStackTrace();
            et.rollback();
        }finally {
            em.close();
        }

        emf.close();
    }

}