package com.sparta.myselectshopbeta.naver.service;

import com.sparta.myselectshopbeta.naver.dto.ItemDto;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class NaverApiService {  //지금 당장은 하단 코드를 이해할 필요는 없고, 자바로 네이버 api 와 소통하는 방법 (네이버 dev 다큐먼트 참고)

    public List<ItemDto> searchItems(String query) {
        RestTemplate rest = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.add("X-Naver-Client-Id", ""); // 애플리케이션 등록시 발급된 클라이언드 아이디값
        headers.add("X-Naver-Client-Secret", ""); // 애플리케이션 등록시 발급된 클라이언트 시크릿키값
        String body = "";

        HttpEntity<String> requestEntity = new HttpEntity<String>(body, headers);
        ResponseEntity<String> responseEntity = rest.exchange("https://openapi.naver.com/v1/search/shop.json?display=15&query=" + query , HttpMethod.GET, requestEntity, String.class);

        HttpStatus httpStatus = responseEntity.getStatusCode();
        int status = httpStatus.value();
        log.info("NAVER API Status Code : " + status);

        String response = responseEntity.getBody();

        return fromJSONtoItems(response);
    }

    public List<ItemDto> fromJSONtoItems(String response) {  //내부에서 dto 로 변환이 된는 로직수행

        JSONObject rjson = new JSONObject(response);
        JSONArray items  = rjson.getJSONArray("items");
        List<ItemDto> itemDtoList = new ArrayList<>();

        for (int i=0; i<items.length(); i++) {
            JSONObject itemJson = items.getJSONObject(i);
            ItemDto itemDto = new ItemDto(itemJson);
            itemDtoList.add(itemDto);
        }

        return itemDtoList;
    }
}