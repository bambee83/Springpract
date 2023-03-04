package com.sparta.springiocdifin.entity;

import lombok.Getter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 롬복 에노테이션
@Entity(name = "orders") //이미 등록된 예약어
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String foodName;
    private int price;
    private int amount; // 필드 주입

    public Order() {} //기본 생성자

    public Order(String foodName, int price, int amount) { //초기화 할 생성자
        this.foodName = foodName;
        this.price = price;
        this.amount = amount;
    }

    public void setPriceAmount() {
        this.price *= this.amount;
    }
}