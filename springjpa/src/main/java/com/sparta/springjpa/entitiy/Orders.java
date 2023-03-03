package com.sparta.springjpa.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Getter
@Entity
@NoArgsConstructor

public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne //다대일 owner(n) : restraunt(1)
    @JoinColumn(name = "food_id")  //food 의 id로 join 하겠다
    private Food food;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    public Orders(Food food, Member member) {
        this.food = food;
        this.member = member;
    }
}
