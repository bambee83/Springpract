package com.example.springmvclivelecture230226.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LegacyController {

    private static long visitCount = 0;

    @GetMapping("/")
    public String getStaticPage() {
        // /templates 경로에서 찾기 때문에 static 내부 html 페이지는 찾을 수 없음
        return "index";
    }

    @GetMapping("/template")
    public String getTemplatePage() {
        return "index";
    }

    @GetMapping("/dynamic-visit")
    public String helloHtmlFile(Model model) {
        visitCount++;
        model.addAttribute("visits", visitCount);
        return "index";
    }

}
