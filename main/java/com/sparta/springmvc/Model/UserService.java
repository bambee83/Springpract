package com.sparta.springmvc.Model;

import com.sparta.springmvc.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service // 스프링이 Model계층의 서비스로 인식할 수 있게끔 하기위함
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    // 모델 계층
    // User (@Entity) : 데이터베이스의 테이블 역할을한다.
    // UserRepository : 데이터베이스와 통신한다.
    // 회원기입의 핵심 비즈니스 로직
    // 1. 회원의 데이터를 데이터베이스에 저장한다.
    public void signUp(UserRequestDto userRequestDto){
        // 1. 테이블에 값을 셋팅한다 (User 객체에 값을 셋팅을한다.)
            // 1-1 : 사용자가 보낸 값을 꺼낸다.
            String email = userRequestDto.getEmail();
            String username = userRequestDto.getUsername();
            String password = userRequestDto.getPassword();

            // 1-2 : User 객체에 값을 셋팅한다.
            User user = new User();
            user.setEmail(email);
            user.setUsername(username);
            user.setPassword(password);

        // 2. 값을 셋팅한 User 객체를 데이터베이스에 저장한다.
            // 2-1 : 유저 레포지토리가 데이터베이스에 유저를 저장한다.
            userRepository.save(user);
    }

}
