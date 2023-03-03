package com.sparta.springmvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/response")  //전체 url을 response 로 받게 설정
public class HelloResponseController {

    private static long visitCount = 0;
    //서버가 죽지 않는 이상 값이 0으로 초기화되지 않고 유지됨 (디스페쳐엔서블릿?템플릿엔진?을 통해 타고 들어옴)

    @GetMapping("/html/redirect")
    public String htmlFile() {
        return "redirect:/hello.html";
    } //정적 html > redirect, .html 까지 명시해야한다

    @GetMapping("/html/templates")
    public String htmlTemplates() {
        return "hello";
    }  //templates 경로에서 찾기 때문에 static 내부 html 은 찾을 수 없음

    @ResponseBody   // @ResponseBody View 를 사용하지 않고, HTTP Body 에 들어갈 String 을 직접 입력
    @GetMapping("/body/html") //뒤에 html 붙인경우 static 으로 호출 또는 경로 설정 //하단매서드와 핸들러매핑이 매칭해줌.
    public String helloStringHTML() {
        return "<!DOCTYPE html>" +
                "<html>" +
                "<head><meta charset=\"UTF-8\"><title>By @ResponseBody</title></head>" +
                "<body> Hello, 정적 웹 페이지!!</body>" +
                "</html>";
    }

    @GetMapping("/html/dynamic")
    public String helloHtmlFile(Model model) {  //model 이라는 객체를 받아서 객체 안에 key: value 형식으로 데이터를 넣어준다
        visitCount++;
        model.addAttribute("visits", visitCount);
        return "hello-visit";    //templates 엔진을 사용하기 때문에 새로고침해도 counting 유지
    }

    @ResponseBody
    @GetMapping("/json/string") //스트링이지만 jason 형식으로 반환
    public String helloStringJson() {
        return "{\"name\":\"르세라핌\",\"age\":20}";
    }

    @ResponseBody
    @GetMapping("/json/class")  //star 객체가 반환 (생성자를 통해 초기값을 주는 형태)
    public Star helloJson() {
        return new Star("르세라핌", 20);
    }
}
