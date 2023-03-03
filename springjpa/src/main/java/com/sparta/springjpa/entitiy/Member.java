package com.sparta.springjpa.entitiy;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter //값을 가져오겠다
@Entity //엔티티로 사용하겠다
@NoArgsConstructor //기본 생성자 생성

public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String MemberName;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Orders> orders = new ArrayList<>();

    public Member(String memberName) {
        MemberName = memberName;
    }
}
