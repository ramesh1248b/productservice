package com.mycomp.productservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GenericProductDto {
    private Long id;
    private String title ;
    private String image ;
    private double price ;
    private String category ;
    private String description ;
}
