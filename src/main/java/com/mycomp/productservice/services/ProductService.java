package com.mycomp.productservice.services;

import com.mycomp.productservice.dtos.GenericProductDto;
import com.mycomp.productservice.models.Product;

import java.util.List;

public interface ProductService {
    Product getProductById(Long id) ;
    GenericProductDto createProduct(GenericProductDto product);
    public List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProduct(Long id) ;

}
