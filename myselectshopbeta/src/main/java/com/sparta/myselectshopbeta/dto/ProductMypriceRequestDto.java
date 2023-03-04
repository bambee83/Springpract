package com.sparta.myselectshopbeta.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductMypriceRequestDto {  //myPRICE 를 직접 받아와서 업데이트 해주는 dto
    private int myprice;
}