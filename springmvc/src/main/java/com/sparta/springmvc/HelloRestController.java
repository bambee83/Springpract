package com.sparta.springmvc;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController   // @Controller + @ResponseBody
//@controller 의 역할 + @ResponseBody 의 역할(html 형식이나 jason 타입으로 데이터를 반환할 거야 !)
// @ResponseBody : View 를 사용하지 않고, HTTP Body 에 들어갈 String 을 직접 입력, "자바 객체 → JSON 으로 변환" 은 스프링이 해 줌

@RequestMapping("/rest")  //8080/rest 의 url 로 들어오는 애들을 다 보내라
public class HelloRestController {

    @GetMapping("/json/string")
    public String helloHtmlString() {
        return "<html><body>Hello @ResponseBody</body></html>";
    }

    @GetMapping("/json/list")
    public List<String> helloJson() {
        List<String> words = Arrays.asList("Hello", "Controller", "And", "JSON");

        return words;
    }
}

// jason 데이터를 컨트롤 할때 주로 사용되는 애너테이션 (나머지는 구글링을 통해 그때그때 찾아쓰기)
//@RequestParam > url뒤에 붙는 파라미터의 값을 가져올 때 사용  https://byul91oh.tistory.com/434
//@RequestBody > HTTP 요청의 바디내용을 통째로 자바객체로 변환해서 매핑된 메소드 파라미터로 전달 https://cheershennah.tistory.com/179
//@PathVariable > PathVariable 의 경우 url에서 각 구분자에 들어오는 값을 처리해야 할 때 사용

//Get 방식에서 객체로 바인딩 할 때 @Setter 가 없어도 된다고 말씀드렸는데
//Setter 없이 바인딩 하려면 해당 값들을 초기화 하는 생성자를 전부 오버로딩하여 만들어주는
//롬복의 @AllArgsConstructor 를 사용하시거나 필요한 값들을 초기화 해주는 생성자를 직접 작성 하셔야합니다.