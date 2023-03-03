package com.sparta.springjpa.repository;

import com.sparta.springjpa.entitiy.Food;
import com.sparta.springjpa.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FoodRepository extends JpaRepository<Food, Long> { //<>내부에는 어떤 테이블과 연결을 할지 명시 , database 와 연결해주는 repo


}
