package com.sparta.myselectshopbeta.naver.controller;


import com.sparta.myselectshopbeta.naver.dto.ItemDto;
import com.sparta.myselectshopbeta.naver.service.NaverApiService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor  //네이버 API 서비스와 연결
public class NaverApiController {

    private final NaverApiService naverApiService;  //필드주입

    @GetMapping("/search")  // 키워드로 상품 검색하고 그 결과를 목록으로 보여주기
    public List<ItemDto> searchItems(@RequestParam String query)  {
        return naverApiService.searchItems(query);
    }
}