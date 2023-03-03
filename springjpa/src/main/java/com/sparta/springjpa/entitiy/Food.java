package com.sparta.springjpa.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@Entity
@NoArgsConstructor

public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String foodName;

    @Column(nullable = false)
    private int price;

    @OneToMany(mappedBy = "food",fetch = FetchType.EAGER) // 음식하나에 주문이 여러개, 연관관계(JoinColumn 의 주인이 food)
    private List<Orders> orders = new ArrayList<>(); //초기값세팅

    public Food(String foodName, int price) {  //생성자 추가
        this.foodName = foodName;
        this.price = price;
    }
}
