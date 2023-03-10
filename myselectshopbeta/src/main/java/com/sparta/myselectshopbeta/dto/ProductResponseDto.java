package com.sparta.myselectshopbeta.dto;

import com.sparta.myselectshopbeta.entity.Product;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ProductResponseDto {  //productentity 를 dto에 감싸서 보냄, entity 클래스는 조심히 다뤄야 한다.
    private Long id;
    private String title;
    private String link;
    private String image;
    private int lprice;
    private int myprice;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.link = product.getLink();
        this.image = product.getImage();
        this.lprice = product.getLprice();
        this.myprice = product.getMyprice();
    }
}
