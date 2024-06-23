package com.mycomp.productservice.dtos;

import com.mycomp.productservice.models.Category;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FakeStoreProductDto {
    private Long id ;
    private String title ;
    private String image ;
    private double price ;
    private String category ;
    private String description ;
}
