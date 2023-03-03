package com.sparta.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/request")
public class HelloRequestController {  //클라이언트로부터 어떻게 들어오는지 확인

    @GetMapping("/form/html")
    public String helloForm() {
        return "hello-request-form";
    }

    @GetMapping("/star/{name}/age/{age}")
    @ResponseBody
    public String helloRequestPath(@PathVariable String name, @PathVariable int age)
    {
        return String.format("Hello, @PathVariable.<br> name = %s, age = %d", name, age);
    }

    @GetMapping("/form/param")
    @ResponseBody
    public String helloGetRequestParam(@RequestParam String name, @RequestParam int age) { //get 값이 url 로 들어온다
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }

    @PostMapping("/form/param")
    @ResponseBody
    public String helloPostRequestParam(@RequestParam String name, @RequestParam int age) { //post > url 로 값이 안들어가고 숨겨서 옴
        return String.format("Hello, @RequestParam.<br> name = %s, age = %d", name, age);
    }


    @PostMapping("/form/model")
    @ResponseBody
    public String helloRequestBodyForm(@ModelAttribute Star star) {  //@ModelAttribute 받아올 값이 많아지면 스프링에서는 객체형식으로 받는다
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    } //star 객체(필드) 에 접근을 해서 값을 가져온다.. @ModelAttribute 는 생략 가능 !

    @PostMapping("/form/json") //@RequestBody json 형식으로 데이터가 body 안에 넘어간다.
    @ResponseBody
    public String helloPostRequestJson(@RequestBody Star star) {
        return String.format("Hello, @RequestBody.<br> (name = %s, age = %d) ", star.name, star.age);
    }
}
