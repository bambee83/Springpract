package com.sparta.springmvc.Controller;

import com.sparta.springmvc.Model.UserService;
import com.sparta.springmvc.UserRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller // -> 스프링이 Controller (유저의 요청을 수신하는 객체)로 인식할 수 있어
@RequiredArgsConstructor
public class UserContorller {
//   1. 사용자는 회원가입할 때 필요한 데이터를 보내요
//   2. UserRequestDto는 사용자가 보낸 데이터를 Model 계층으로 보내요
//   3. 회원가입할 때 필요한 데이터를 받아서 저희는 UserTable에 저장할거에요

    private final UserService userService;
    @PostMapping("/signup")
    public void singup(@RequestBody UserRequestDto userRequestDto) {
        userService.signUp(userRequestDto);
    }
}
