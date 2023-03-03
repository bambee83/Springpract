package com.sparta.springjpa.repository;

import com.sparta.springjpa.entitiy.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {

    Optional<Member> findByMemberName(String memberName); //Service에서 사용하기 위한 메서드 생성
}
