package com.sparta.myselectshopbeta.naver.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@Getter
@NoArgsConstructor
public class ItemDto {
    private String title;
    private String link;
    private String image;
    private int lprice;

    public ItemDto(JSONObject itemJson) {  //JsonObject 를 파라미터로 받는다
        this.title = itemJson.getString("title"); //getString 에 키값을 넣으면 그 키값을 가져와서 dto 변수 안에 넣어준다.
        this.link = itemJson.getString("link");
        this.image = itemJson.getString("image");
        this.lprice = itemJson.getInt("lprice");
    }
}