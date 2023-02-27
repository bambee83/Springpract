package com.sparta.springmvc.Model;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // repository -> 의존성주입
public interface UserRepository extends JpaRepository<User , Long> {
//    JpaRepository<Long , User> 데이터베이스의 user table과 통신할 수 있게 됐다
}
