package com.sparta.springiocdifin.repository;


import com.sparta.springiocdifin.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> { //연결할 entity 객체를 넣어준다 > order 의 테이블에 접근 가능
    List<Order> findAllByFoodName(String foodName);  //반환 타입은 List<Order> , 파라미터(매개변수로 값울 넣어주기!)
    // 자동으로 쿼리를 만들어서 데이터 베이스에 데이터베이스에 쏴준다...!
}

