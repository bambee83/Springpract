package com.sparta.springmvc;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter  // @ModelAttribute 사용시 반드시 @Setter 달아줘야 한다
@AllArgsConstructor
public class Star {
    String name;
    int age;
}

//서버에서 받는 필드값과 클라이언트가 보내주는 필드값이 정확히 일치해야한다 !!!
//api 명세서의 중요성